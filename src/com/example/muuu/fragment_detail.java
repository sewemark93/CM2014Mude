package com.example.muuu;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.muuu.WebViewActivity;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.Toast;


public class fragment_detail extends Fragment implements OnClickListener
{
    View rootView;
    MainImageAdapter mainimageadapter=null;
    ImageView mainimage;
    ImageView designerimage;
    /*Variable to handle database */
    MyDBHandler dbHandler;
    String itemname;
    Item item=null;
    /*Variables used for twitter integration */
	private static final String PREF_NAME = "sample_twitter_pref";
	private static final String PREF_KEY_OAUTH_TOKEN = "oauth_token";
	private static final String PREF_KEY_OAUTH_SECRET = "oauth_token_secret";
	private static final String PREF_KEY_TWITTER_LOGIN = "is_twitter_loggedin";
	private static final String PREF_USER_NAME = "twitter_user_name";
	
	public static final int WEBVIEW_REQUEST_CODE = 100;

	private ProgressDialog pDialog;

	private static Twitter twitter;
	private static RequestToken requestToken;
	
	private static SharedPreferences mSharedPreferences;

	/*Variables responsible for facebook sharing  */
    private String consumerKey = null;
	private String consumerSecret = null;
	private String callbackUrl = null;
	private String oAuthVerifier = null;

	private UiLifecycleHelper uiHelper;

	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState)
	{
		
		 final View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
		 uiHelper = new UiLifecycleHelper(getActivity(), null);
	     uiHelper.onCreate(savedInstanceState);
		 initTwitterConfigs();

		/* Enabling strict mode */
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		if (TextUtils.isEmpty(consumerKey) || TextUtils.isEmpty(consumerSecret))
		{
		
			return null;
		}

		/* Initialize application preferences */
		mSharedPreferences = getActivity().getSharedPreferences(PREF_NAME, 0);

		boolean isLoggedIn = mSharedPreferences.getBoolean(PREF_KEY_TWITTER_LOGIN, false);
			
			
			
			/*checks if user is already logged in (twitter) */
			if (isLoggedIn)
			{
              

			}
			else 
			{
				Uri uri = getActivity().getIntent().getData();
				if (uri != null && uri.toString().startsWith(callbackUrl)) 
				{
				    String verifier = uri.getQueryParameter(oAuthVerifier);

					try 
					{
						/* Getting oAuth authentication token */
						AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, verifier);
                        /* Getting user id form access token */
						long userID = accessToken.getUserId();
						final User user = twitter.showUser(userID);
			
                        /* save updated token */
						saveTwitterInfo(accessToken);
					}
					catch (Exception e)
					{
						Log.e("Failed to login Twitter!!", e.getMessage());
					}
				}

			}
		  Typeface typeFace=Typeface.createFromAsset(getActivity().getAssets(),"fonts/helveticaneuecon.ttf");
		  dbHandler = new MyDBHandler(getActivity(), null, null, 1);
		  /*this part of code checks which object from database is to be displayed 
		   *then finds this object in database and gets all information about it
		    */
		  int ID=getArguments().getInt("ImageId");
	    	 
		  if(ID == R.id.furo) 
		  {
			item = dbHandler.findItem("furo");
			itemname="furo";
		  } 
		  else if(ID==R.id.almanaque)
		  {
			  
			 item = dbHandler.findItem("almanaque");
		     itemname="almanaque";
		  }
		  else if(ID==R.id.cadeiragoncalo)
		  {
			  
			  item=dbHandler.findItem("cadeiragoncalo");
			  itemname="cadeiragoncalo";
		  }
		  else if(ID==R.id.linhacortez)
		  {
			  
			  item=dbHandler.findItem("linhacortez");
			  itemname="linhacortez";
		  }
		  else if(ID==R.id.congressointpessoano)
		  {
			  
			  item=dbHandler.findItem("congressointpessoano");
			  itemname="congressointpessoano";
		  }
		  else if(ID==R.id.candeeiroterra)
		  {
			  
			  item=dbHandler.findItem("candeeiroterra");
			  itemname="candeeiroterra";
		  }
		  else if(ID==R.id.coleccaofiligrana)
		  {
			  
			  item=dbHandler.findItem("coleccaofiligrana");
			  itemname="coleccaofiligrana";
		  }
		  else if(ID==R.id.cadeiraosaka)
		  {
			  
			  item=dbHandler.findItem("cadeiraosaka");
			  itemname="cadeiraosaka";
		  }
		  else if(ID==R.id.cadeiraal)
		  {
			  
			  item=dbHandler.findItem("cadeiraal");
			  itemname="cadeiraal";
		  }
		  else if(ID==R.id.torneirapanda)
		  {
			  
			  item=dbHandler.findItem("torneirapanda");
			  itemname="torneirapanda";
		  }
		  else if(ID==R.id.portobarros)
		  {
			  
			  item=dbHandler.findItem("portobarros");
			  itemname="portobarros";
		  }
		  else if(ID==R.id.puxadorbeta)
		  {
			  
			  item=dbHandler.findItem("puxadorbeta");
			  itemname="puxadorbeta";
		  }
		  else if(ID==R.id.espelhoalvaro)
		  {
			  
			  item=dbHandler.findItem("espelhoalvaro");
			  itemname="espelhoalvaro";
		  }
		  else if(ID==R.id.linhagoa)
		  {
			  
			  item=dbHandler.findItem("linhagoa");
			  itemname="linhagoa";
		  }
		  
		  mainimageadapter = new MainImageAdapter(item.getImgRes(),rootView.getResources(),rootView.getContext().getPackageName(),item.getNumberOfPics());
		  mainimage= (ImageView)rootView.findViewById(R.id.image);
		  Button clickButton = (Button)rootView.findViewById(R.id.moreinfobutton);
		  
		  if(mainimageadapter.GetDesignerImage()==0)
		  {
			  clickButton.setVisibility(View.GONE);
			  
		  }
		  /*setting main */
		  mainimage.setImageResource(mainimageadapter.GetMainImage());
		  /*this part of code finds all textviews and sets appropriate font */
		     final TextView textView0 = (TextView)rootView.findViewById(R.id.textviewname);
	   		 textView0.setText(item.getAuthor());
		     final TextView textView1 = (TextView)rootView.findViewById(R.id.name);
	   		 textView1.setText(item.getItemTitle());
			 final TextView textView2 = (TextView)rootView.findViewById(R.id.categorialabel);
			 final TextView textView3 = (TextView)rootView.findViewById(R.id.categoriavalue);
			 textView3.setText(item.getCategory());
			 final TextView textView4 = (TextView)rootView.findViewById(R.id.tipolabel);
			 final TextView textView5 = (TextView)rootView.findViewById(R.id.tipovalue);
		     textView5.setText(item.getType());;
			 final TextView textView6 = (TextView)rootView.findViewById(R.id.datalabel);
			 final TextView textView7 = (TextView)rootView.findViewById(R.id.datavalue);
			 textView7.setText(String.valueOf(item.getDate()));
			 final TextView textView8 = (TextView)rootView.findViewById(R.id.designerlabel);
			 final TextView textView9 = (TextView)rootView.findViewById(R.id.designervalue);
			 textView9.setText(item.getAuthor());
			 final TextView textView10 = (TextView)rootView.findViewById(R.id.fabricantelabel);
			 final TextView textView11 = (TextView)rootView.findViewById(R.id.fabricantevalue);
			 textView11.setText(item.getAuthor());
		 	 final TextView textView12 = (TextView)rootView.findViewById(R.id.paislabel);
			 final TextView textView13 = (TextView)rootView.findViewById(R.id.paisvalue);
			 textView13.setText(item.getCountry());
		 	 final TextView textView14 = (TextView)rootView.findViewById(R.id.corlabel);
			 final TextView textView15 = (TextView)rootView.findViewById(R.id.corvalue);
			 textView15.setText(item.getColour());
		 	 final TextView textView16 = (TextView)rootView.findViewById(R.id.materialslabel);
		 	 final TextView textView17 = (TextView)rootView.findViewById(R.id.materialsvalue);
		 	 textView17.setText(item.getMaterial());
			 final TextView textView18 = (TextView)rootView.findViewById(R.id.objectdescription);
		 	 textView1.setTypeface(typeFace);
			 textView2.setTypeface(typeFace);
			 textView3.setTypeface(typeFace);
			 textView4.setTypeface(typeFace);
			 textView5.setTypeface(typeFace);
			 textView6.setTypeface(typeFace);
			 textView7.setTypeface(typeFace);
			 textView8.setTypeface(typeFace);
			 textView9.setTypeface(typeFace);
			 textView10.setTypeface(typeFace);
			 textView11.setTypeface(typeFace);
			 textView12.setTypeface(typeFace);
			 textView13.setTypeface(typeFace);
			 textView14.setTypeface(typeFace);
			 textView15.setTypeface(typeFace);
			 textView16.setTypeface(typeFace);
			 textView17.setTypeface(typeFace);
			 textView18.setTypeface(typeFace);
		      /*this part of code reads object description from file */  
			  AssetManager am = rootView.getContext().getAssets();
			  FileReaderHelper reader = new FileReaderHelper();
			  ByteArrayOutputStream byteArrayOutputStream = reader.read(item.getImgRes()+"des"+".txt", am);
			
			if(byteArrayOutputStream==null)
			{
				textView18.setText("");

			}
			else
			{
				textView18.setText(byteArrayOutputStream.toString());
			}
	
			 final Button likeButton = (Button)rootView.findViewById(R.id.likebutton);
			 if(item.getFavourite() ==1)
	    	 {
	    	     likeButton.setBackgroundResource(R.drawable.fav2);
	    	 }
	    	 else
	    	 {
	    
	        	 likeButton.setBackgroundResource(R.drawable.fav); 
	    		 
	    	 }
			 /*handling like button to like or dislike object */
		     likeButton.setOnClickListener( new OnClickListener()
		     {

		             @Override
		             public void onClick(View v) 
		             {
		            	
		            	 if(item.getFavourite() ==0)
		            	 {
		            		 dbHandler.changeFavourite(item.getItemTitle(),1);
		            		 likeButton.setBackgroundResource(R.drawable.fav2);
		            		 item = dbHandler.findItem(itemname);
		            	 }
		            	 else
		            	 {
		            		 dbHandler.changeFavourite(item.getItemTitle(),0);
			            	 likeButton.setBackgroundResource(R.drawable.fav); 
			            	 item = dbHandler.findItem(itemname);
		            	 }
		           
		            }
		         });

		/*handling next and previous arrows to handle image navigation */     
		final ImageView nextButton = (ImageView)rootView.findViewById(R.id.right_arrow);
		nextButton.setOnClickListener( new OnClickListener() {

		             @Override
		             public void onClick(View v) {
		            	
		            	 mainimage.setImageResource(mainimageadapter.GetNextImage());
		            
		             }
		         });
		
		final ImageView prevButton = (ImageView)rootView.findViewById(R.id.left_arrow);
		prevButton.setOnClickListener( new OnClickListener() {

		             @Override
		             public void onClick(View v) {

		            	 mainimage.setImageResource(mainimageadapter.GetPrevImage());
		             }
		         });
		  
		 /*handling facebook sharing */
		 final Button facebookButton = (Button)rootView.findViewById(R.id.facebookbutton);
		 facebookButton.setOnClickListener( new OnClickListener()
		 {

		             @Override
		             public void onClick(View v)
		             {

                         /*this part of code handle facebook sharing 
                          * first check if app can present shar dialog with photos
                          * then gets image resource 
                          * finally share on facebook
                          */
		            	 boolean canPresentShareDialog;
		            	 canPresentShareDialog = FacebookDialog.canPresentShareDialog(getActivity(),FacebookDialog.ShareDialogFeature.SHARE_DIALOG);
		            	 boolean canPresentShareDialogWithPhotos;
						 canPresentShareDialogWithPhotos = canPresentShareDialogWithPhotos = FacebookDialog.canPresentShareDialog(getActivity(),FacebookDialog.ShareDialogFeature.PHOTOS);
		            	 int resourceId2 = rootView.getResources().getIdentifier( item.getImgRes()+ String.valueOf(1), "drawable", rootView.getContext().getPackageName() );
        			     Bitmap bitmap =BitmapFactory.decodeResource(getResources(),resourceId2);
        			     List<Bitmap> bitmaps = new ArrayList<Bitmap>();
            			 bitmaps.add(bitmap);
		            	 if (canPresentShareDialogWithPhotos)
		            	 {
		                     FacebookDialog shareDialog = createShareDialogBuilderForPhoto(bitmap).build();
		                     uiHelper.trackPendingDialogCall(shareDialog.present());
		                
		            	 }
		            }

		         });
		 final Button twitterButton = (Button)rootView.findViewById(R.id.twitterbutton);
		 twitterButton.setOnClickListener( new OnClickListener() {

		             @Override
		             public void onClick(View v) 
		             {
		            	 /*loginToTwitter function handle twitter sharing */
		            	 try {
		            		 	loginToTwitter();
		            		 }
		            		 catch(Exception e) 
		            		 {
		            		      
		            		 }
		             }
		         });
		 
		 /*this button handle showing and hidding more information about designer */
		 clickButton.setOnClickListener( new OnClickListener() 
		 {

		             @Override
		             public void onClick(View v) 
		             {
		            	  
		            	 
		            	 Bundle bundle=new Bundle();
		     	    	 bundle.putString("imagrres", itemname);
		            	
		            	 FragmentManager fragmentManager = getFragmentManager();
			            	if (fragmentManager.findFragmentById(R.id.author_fragment_container) != null) 
			            		{
			            			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			            			fragment_aboutauthor myFrag = (fragment_aboutauthor)fragmentManager.findFragmentById(R.id.author_fragment_container);
			            		    fragmentTransaction.remove(myFrag);
			            		    fragmentTransaction.commit();
			            		}
		            	 
			            		else
			            			
			            		{
			            		
			            		fragment_aboutauthor fra = new fragment_aboutauthor();
			            		fra.setArguments(bundle);
		            			fragmentManager.beginTransaction().replace(R.id.author_fragment_container, fra).commit();        
			            		
			            		}
		            	
		                
		             }
		         });

      return rootView;
   
    } 
	void addShowHideListener(int buttonId, final Fragment fragment)
	{
        final Button button = (Button)rootView.findViewById(buttonId);
        button.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.animator.fade_in,
                        android.R.animator.fade_out);
                if (fragment.isHidden()) {
                    ft.show(fragment);
                    
                } else {
                    ft.hide(fragment);
               
                }
                ft.commit();
            }
        });
	}
   private FacebookDialog.PhotoShareDialogBuilder createShareDialogBuilderForPhoto(Bitmap... photos) 
   {
        return new FacebookDialog.PhotoShareDialogBuilder(getActivity())
                .addPhotos(Arrays.asList(photos));
    }
	private void saveTwitterInfo(AccessToken accessToken) 
	{
			
			long userID = accessToken.getUserId();
			
			User user;
			try
			{
				user = twitter.showUser(userID);
			
				String username = user.getName();
	
				/* Storing oAuth tokens to shared preferences */
				Editor e = mSharedPreferences.edit();
				e.putString(PREF_KEY_OAUTH_TOKEN, accessToken.getToken());
				e.putString(PREF_KEY_OAUTH_SECRET, accessToken.getTokenSecret());
				e.putBoolean(PREF_KEY_TWITTER_LOGIN, true);
				e.putString(PREF_USER_NAME, username);
				e.commit();
	
			} catch (TwitterException e1) 
			{
				e1.printStackTrace();
			}
		}
	
	private void initTwitterConfigs() {
		consumerKey = getString(R.string.twitter_consumer_key);
		consumerSecret = getString(R.string.twitter_consumer_secret);
		callbackUrl = getString(R.string.twitter_callback);
		oAuthVerifier = getString(R.string.twitter_oauth_verifier);
	}
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (resultCode == Activity.RESULT_OK) {
			String verifier = data.getExtras().getString(oAuthVerifier);
			try {
				AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, verifier);
                saveTwitterInfo(accessToken);

			} catch (Exception e) {
				Log.e("Twitter Login Failed", e.getMessage());
			}
		}

		super.onActivityResult(requestCode, resultCode, data);
		 uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
		        @Override
		        public void onError(FacebookDialog.PendingCall pendingCall, Exception error, Bundle data) {
		            Log.e("Activity", String.format("Error: %s", error.toString()));
		        }

		        @Override
		        public void onComplete(FacebookDialog.PendingCall pendingCall, Bundle data) {
		            Log.i("Activity", "Success!");
		        }
		    });
	 }
	@Override
	public void onResume() {
	    super.onResume();
	    uiHelper.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    uiHelper.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
	    super.onPause();
	    uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
	    super.onDestroy();
	    uiHelper.onDestroy();
	}
	private void loginToTwitter() {
		boolean isLoggedIn = mSharedPreferences.getBoolean(PREF_KEY_TWITTER_LOGIN, false);
		/*this part of code check is user is logged in  
		 *  if not app presents form to log in
		 *  then updates twitter status
		 */
		if (!isLoggedIn) {
			final ConfigurationBuilder builder = new ConfigurationBuilder();
			builder.setOAuthConsumerKey(consumerKey);
			builder.setOAuthConsumerSecret(consumerSecret);

			final Configuration configuration = builder.build();
			final TwitterFactory factory = new TwitterFactory(configuration);
			twitter = factory.getInstance();

			try {
			
				requestToken = twitter.getOAuthRequestToken(callbackUrl);
				final Intent intent = new Intent(getActivity(), WebViewActivity.class);
				intent.putExtra(WebViewActivity.EXTRA_URL, requestToken.getAuthenticationURL());
				startActivityForResult(intent, WEBVIEW_REQUEST_CODE);
				
				
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		}
		new updateTwitterStatus().execute(item.getItemTitle());
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	/*class to update twitter status with photo of the object */
	class updateTwitterStatus extends AsyncTask<String, String, Void> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Posting to twitter...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		protected Void doInBackground(String... args) {

			String status = args[0];
			try {
				ConfigurationBuilder builder = new ConfigurationBuilder();
				builder.setOAuthConsumerKey(consumerKey);
				builder.setOAuthConsumerSecret(consumerSecret);
				
				// Access Token
				String access_token = mSharedPreferences.getString(PREF_KEY_OAUTH_TOKEN, "");
				// Access Token Secret
				String access_token_secret = mSharedPreferences.getString(PREF_KEY_OAUTH_SECRET, "");

				AccessToken accessToken = new AccessToken(access_token, access_token_secret);
				Twitter twitter = new TwitterFactory(builder.build()).getInstance(accessToken);

				// Update status
				StatusUpdate statusUpdate = new StatusUpdate(status);
				
				InputStream is = getResources().openRawResource(mainimageadapter.GetMainImage());
				statusUpdate.setMedia("image.jpg", is);
				
				twitter4j.Status response = twitter.updateStatus(statusUpdate);

				Log.d("Status", response.getText());
				
			} catch (TwitterException e) {
				Log.d("Failed to post!", e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			
			/* Dismiss the progress dialog after sharing */
			pDialog.dismiss();
			Toast.makeText(getActivity(), "Posted to Twitter!", Toast.LENGTH_SHORT).show();
		}

	}	

}
