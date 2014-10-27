package competent.groove.thegrooveboss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.devspark.appmsg.AppMsg;
import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class ViewGuest_list  extends Fragment implements OnTabChangeListener {
	
	ImageView greaterimgview, lessimgview, disapprove_view, guest_regisview;
	TextView greateractionbartv;
	SharedPreferences pref;
	private String getoutletid;
	private TabHost mTabHost;
	private int mCurrentTab;
	public static final String TAB_1 = "Open";
	public static final String TAB_2 = "Approved";
	public static final String TAB_3 = "Attended";
	SwipeListView listview , approvelistview, attendedlist;
	private int width1;
	private int height1;
	private int xwidth;
	private int buttonwidth;
	private ProgressDialog simpleWaitDialog;
	
	Vector<String > globalvector = new Vector<String>();
	Vector<String > globalvector1 = new Vector<String>();
	Vector<String > globalvector2 = new Vector<String>();
	Vector<String > globalvector3 = new Vector<String>();
	Vector<String > globalvector4 = new Vector<String>();
	Vector<String > globalvector5 = new Vector<String>();
	Vector<String > globalvector6 = new Vector<String>();
	Vector<String > globalvector7 = new Vector<String>();
	Vector<String > globalvector_mobno = new Vector<String>();
	//=========================================================
	
	Vector<String > open_globalvector = new Vector<String>();
	Vector<String > open_globalvector1 = new Vector<String>();
	Vector<String > open_globalvector2 = new Vector<String>();
	Vector<String > open_globalvector3 = new Vector<String>();
	Vector<String > open_globalvector4 = new Vector<String>();
	Vector<String > open_globalvector5 = new Vector<String>();
	Vector<String > open_globalvector6 = new Vector<String>();
	Vector<String > open_globalvector7 = new Vector<String>();
	Vector<String > open_globalvector_mobno = new Vector<String>();
	//====================================================================
	
	
	Vector<String > approved_globalvector = new Vector<String>();
	Vector<String > approved_globalvector1 = new Vector<String>();
	Vector<String > approved_globalvector2 = new Vector<String>();
	Vector<String > approved_globalvector3 = new Vector<String>();
	Vector<String > approved_globalvector4 = new Vector<String>();
	Vector<String > approved_globalvector5 = new Vector<String>();
	Vector<String > approved_globalvector6 = new Vector<String>();
	Vector<String > approved_globalvector7 = new Vector<String>();
	Vector<String > approved_globalvector_mobno = new Vector<String>();
	
	//==============================================================
	
	Vector<String > xapproved_globalvector = new Vector<String>();
	Vector<String > xapproved_globalvector1 = new Vector<String>();
	Vector<String > xapproved_globalvector2 = new Vector<String>();
	Vector<String > xapproved_globalvector3 = new Vector<String>();
	Vector<String > xapproved_globalvector4 = new Vector<String>();
	Vector<String > xapproved_globalvector5 = new Vector<String>();
	Vector<String > xapproved_globalvector6 = new Vector<String>();
	Vector<String > xapproved_globalvector7 = new Vector<String>();
	Vector<String > xapproved_globalvector_mobno = new Vector<String>();
	
	//================================================================
	
	Vector<String > attend_globalvector = new Vector<String>();
	Vector<String > attend_globalvector1 = new Vector<String>();
	Vector<String > attend_globalvector2 = new Vector<String>();
	Vector<String > attend_globalvector3 = new Vector<String>();
	Vector<String > attend_globalvector4 = new Vector<String>();
	Vector<String > attend_globalvector5 = new Vector<String>();
	Vector<String > attend_globalvector6 = new Vector<String>();
	Vector<String > attend_globalvector7 = new Vector<String>();
	Vector<String > attend_globalvector_mobno = new Vector<String>();
	
	//==============================================================
	
	Vector<String > xattend_globalvector = new Vector<String>();
	Vector<String > xattend_globalvector1 = new Vector<String>();
	Vector<String > xattend_globalvector2 = new Vector<String>();
	Vector<String > xattend_globalvector3 = new Vector<String>();
	Vector<String > xattend_globalvector4 = new Vector<String>();
	Vector<String > xattend_globalvector5 = new Vector<String>();
	Vector<String > xattend_globalvector6 = new Vector<String>();
	Vector<String > xattend_globalvector7 = new Vector<String>();
	Vector<String > xattend_globalvector_mobno = new Vector<String>();
	
	
	ArrayList<String> global_date_arryist = new ArrayList<String>();
	ArrayList<String> answers  = new ArrayList<String>();
	ArrayList<String> answers1  = new ArrayList<String>();
	ArrayList<String> answers2 = new ArrayList<String>();
	
	String firstdate =" ", lastdate =" ";
	private int counter = 0;
	private int open_counter,approve_counter,attend_counter;
	
	List<RowItem2> rowItems;
	List<RowItem3> rowItems3;
	List<RowItem4> rowItems4;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
        View rootView = inflater.inflate(R.layout.fragment_community, container, false);
		ActionBar bar = getActivity().getActionBar();
		
		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_HOME_AS_UP);

		LayoutInflater li = LayoutInflater.from(getActivity());
		View customView = li.inflate(R.layout.logout_actionbar, null);
		bar.setDisplayShowCustomEnabled(true);
		bar.setCustomView(customView, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
		bar.setCustomView(customView);

		bar.show();
		
		
		Log.i("counter", "" + counter );
		
		new ImageDownloader2().execute();
		
		pref = PreferenceManager.getDefaultSharedPreferences(getActivity()); // 0 - for private mode;
	    getoutletid = ""+pref.getString("outletid", "no outletid");
		Log.i("getoutletid", "" + getoutletid );
		
		disapprove_view = (ImageView)getActivity().getActionBar().getCustomView().findViewById(R.id.disapprove_imageView1);
		greaterimgview = (ImageView)getActivity().getActionBar().getCustomView().findViewById(R.id.greaterimageView1);
		lessimgview = (ImageView)getActivity().getActionBar().getCustomView().findViewById(R.id.imageViewless);
		guest_regisview= (ImageView)getActivity().getActionBar().getCustomView().findViewById(R.id.guestregis);
		
		greaterimgview.setVisibility(View.VISIBLE);
		lessimgview.setVisibility(View.VISIBLE);
		disapprove_view.setVisibility(View.VISIBLE);
		guest_regisview.setVisibility(View.VISIBLE);
		
		greateractionbartv = (TextView)getActivity().getActionBar().getCustomView().findViewById(R.id.greatertextView1);
		greateractionbartv.setVisibility(View.VISIBLE);
		
		TextView actionbartv = (TextView)getActivity().getActionBar().getCustomView().findViewById(R.id.logoutactionbarview);
		TextView actionbartv2 = (TextView)getActivity().getActionBar().getCustomView().findViewById(R.id.guestViewplace);

		actionbartv.setText("GUEST");
		actionbartv2.setText("LIST");
		
		 listview = (SwipeListView)rootView.findViewById(R.id.tab_1);
		 
		 approvelistview = (SwipeListView)rootView.findViewById(R.id.tab_2);
		 
		 attendedlist = (SwipeListView)rootView.findViewById(R.id.tab_3);
		
		 mTabHost = (TabHost) rootView.findViewById(android.R.id.tabhost);
		 
		 setupTabs();
	        
	     mTabHost.setOnTabChangedListener(this);
		 mTabHost.setCurrentTab(mCurrentTab);
		 
		 Display display = getActivity().getWindowManager().getDefaultDisplay();
		 Point size2 = new Point();
		 display.getSize(size2);
		 width1 = size2.x;
		 height1 = size2.y;
			  
		 //Log.i("width", "" + width1 );
		 //Log.i("height1", "" + height1 );
			  
		 xwidth = 80*width1/100;
		 //Log.i("xwidth", "" + xwidth );
			  
		 buttonwidth = width1 - xwidth;
		 //Log.i("buttonwidth", "" + buttonwidth );
		 
		 
		 greaterimgview.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//Toast.makeText(getActivity(), "hi", Toast.LENGTH_SHORT).show();
					greaterimageview();
				}
			});
			
			lessimgview.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//Toast.makeText(getActivity(), "lessimgview", Toast.LENGTH_SHORT).show();
					lessimageview();
				}
			});
			
			disapprove_view.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent dis_intent = new Intent(getActivity(), DisApproveguestActivity.class);
					startActivityForResult(dis_intent, 3);
					getActivity().overridePendingTransition(R.anim.lefttoright, R.anim.right_to_left);
					
				}
			});
			
			guest_regisview.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent dis_intent = new Intent(getActivity(), GuestRegistActivity.class);
					startActivity(dis_intent);
					getActivity().overridePendingTransition(R.anim.lefttoright, R.anim.right_to_left);
					
				}
			});
			
        
        return rootView;
	}
	
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    setRetainInstance(true);
	    //mTabHost.setOnTabChangedListener(this);
	    mTabHost.setCurrentTab(mCurrentTab);
	   // updateTab(R.id.tab_1);
	}
	
	private void setupTabs() {
	    mTabHost.setup(); // you must call this before adding your tabs!
	    mTabHost.addTab(newTab(TAB_1, R.id.tab_1));
	    mTabHost.addTab(newTab(TAB_2, R.id.tab_2));
	    mTabHost.addTab(newTab(TAB_3, R.id.tab_3));
	    //mTabHost.getTabWidget().setDividerDrawable(TabWidget.SHOW_DIVIDER_MIDDLE);
	}

	private TabSpec newTab(String tag, int tabContentId) {
	    TabSpec spec = mTabHost.newTabSpec(tag);
	    spec.setContent(tabContentId);
	    spec.setIndicator(tag);
	    return spec;
	}
	
	
	private class ImageDownloader2 extends AsyncTask<String, Void, String> {

		private String result3;
		private String approveguest_time;
		
		@Override
		protected void onPreExecute() {
			Log.i("Async-Example", "onPreExecute Called");
			simpleWaitDialog = ProgressDialog.show(getActivity(),"Wait", "Downloading data");
			
			if(!answers.isEmpty()){
				answers.clear();
			}
			if(!answers1.isEmpty()){
				answers1.clear();
			}
			if(!answers2.isEmpty()){
				answers2.clear();
			}
			if(!globalvector.isEmpty()){
				globalvector.removeAllElements();
			     
			}
			if(!globalvector1.isEmpty()){
				globalvector1.removeAllElements();
			     
			}
			if(!globalvector2.isEmpty()){
				globalvector2.removeAllElements();
			     
			}
			if(!globalvector3.isEmpty()){
				globalvector3.removeAllElements();
			     
			}
			if(!globalvector4.isEmpty()){
				globalvector4.removeAllElements();
			     
			}
			
			if(!globalvector5.isEmpty()){
				globalvector5.removeAllElements();
			     
			}
			if(!globalvector6.isEmpty()){
				globalvector6.removeAllElements();
			     
			}
			if(!globalvector7.isEmpty()){
				globalvector7.removeAllElements();
			     
			}
			if(!open_globalvector_mobno.isEmpty()){
				open_globalvector_mobno.removeAllElements();
			     
			}
			
			if(!global_date_arryist.isEmpty()){
				global_date_arryist.clear();
			     
			}
			//==========================================================
			if(!open_globalvector.isEmpty()){
				open_globalvector.removeAllElements();
			     
			}
			if(!open_globalvector1.isEmpty()){
				open_globalvector1.removeAllElements();
			     
			}
			if(!open_globalvector2.isEmpty()){
				open_globalvector2.removeAllElements();
			     
			}
			if(!open_globalvector3.isEmpty()){
				open_globalvector3.removeAllElements();
			     
			}
			if(!open_globalvector4.isEmpty()){
				open_globalvector4.removeAllElements();
			     
			}
			
			if(!open_globalvector5.isEmpty()){
				open_globalvector5.removeAllElements();
			     
			}
			if(!open_globalvector6.isEmpty()){
				open_globalvector6.removeAllElements();
			     
			}
			if(!open_globalvector7.isEmpty()){
				open_globalvector7.removeAllElements();
			     
			}
			if(!open_globalvector_mobno.isEmpty()){
				open_globalvector_mobno.removeAllElements();
			     
			}
			//===============================================
			if(!approved_globalvector.isEmpty()){
				approved_globalvector.removeAllElements();
			     
			}
			if(!approved_globalvector1.isEmpty()){
				approved_globalvector1.removeAllElements();
			     
			}
			if(!approved_globalvector2.isEmpty()){
				approved_globalvector2.removeAllElements();
			     
			}
			if(!approved_globalvector3.isEmpty()){
				approved_globalvector3.removeAllElements();
			     
			}
			if(!approved_globalvector4.isEmpty()){
				approved_globalvector4.removeAllElements();
			     
			}
			
			if(!approved_globalvector5.isEmpty()){
				approved_globalvector5.removeAllElements();
			     
			}
			if(!approved_globalvector6.isEmpty()){
				approved_globalvector6.removeAllElements();
			     
			}
			if(!approved_globalvector7.isEmpty()){
				approved_globalvector7.removeAllElements();
			     
			}
			if(!approved_globalvector_mobno.isEmpty()){
				approved_globalvector_mobno.removeAllElements();
			}
			//==============================================
			if(!xapproved_globalvector.isEmpty()){
				xapproved_globalvector.removeAllElements();
			     
			}
			if(!xapproved_globalvector1.isEmpty()){
				xapproved_globalvector1.removeAllElements();
			     
			}
			if(!xapproved_globalvector2.isEmpty()){
				xapproved_globalvector2.removeAllElements();
			     
			}
			if(!xapproved_globalvector3.isEmpty()){
				xapproved_globalvector3.removeAllElements();
			     
			}
			if(!xapproved_globalvector4.isEmpty()){
				xapproved_globalvector4.removeAllElements();
			     
			}
			
			if(!xapproved_globalvector5.isEmpty()){
				xapproved_globalvector5.removeAllElements();
			     
			}
			if(!xapproved_globalvector6.isEmpty()){
				xapproved_globalvector6.removeAllElements();
			     
			}
			if(!xapproved_globalvector7.isEmpty()){
				xapproved_globalvector7.removeAllElements();
			     
			}
			if(!xapproved_globalvector_mobno.isEmpty()){
				xapproved_globalvector_mobno.removeAllElements();
			}
			//========================================================
			//========================================================
			
			if(!attend_globalvector.isEmpty()){
				attend_globalvector.removeAllElements();
			     
			}
			if(!attend_globalvector1.isEmpty()){
				attend_globalvector1.removeAllElements();
			     
			}
			if(!attend_globalvector2.isEmpty()){
				attend_globalvector2.removeAllElements();
			     
			}
			if(!attend_globalvector3.isEmpty()){
				attend_globalvector3.removeAllElements();
			     
			}
			if(!attend_globalvector4.isEmpty()){
				attend_globalvector4.removeAllElements();
			     
			}
			
			if(!attend_globalvector5.isEmpty()){
				attend_globalvector5.removeAllElements();
			     
			}
			if(!attend_globalvector6.isEmpty()){
				attend_globalvector6.removeAllElements();
			     
			}
			if(!attend_globalvector7.isEmpty()){
				attend_globalvector7.removeAllElements();
			     
			}
			if(!attend_globalvector_mobno.isEmpty()){
				attend_globalvector_mobno.removeAllElements();
			}
			//==============================================
			if(!xattend_globalvector.isEmpty()){
				xattend_globalvector.removeAllElements();
			     
			}
			if(!xattend_globalvector1.isEmpty()){
				xattend_globalvector1.removeAllElements();
			     
			}
			if(!xattend_globalvector2.isEmpty()){
				xattend_globalvector2.removeAllElements();
			     
			}
			if(!xattend_globalvector3.isEmpty()){
				xattend_globalvector3.removeAllElements();
			     
			}
			if(!xattend_globalvector4.isEmpty()){
				xattend_globalvector4.removeAllElements();
			     
			}
			
			if(!xattend_globalvector5.isEmpty()){
				xattend_globalvector5.removeAllElements();
			     
			}
			if(!xattend_globalvector6.isEmpty()){
				xattend_globalvector6.removeAllElements();
			     
			}
			if(!xattend_globalvector7.isEmpty()){
				xattend_globalvector7.removeAllElements();
			     
			}
			if(!xattend_globalvector_mobno.isEmpty()){
				xattend_globalvector_mobno.removeAllElements();
			}
			//==============================================================
			
			if(! GlobalValues.dis_approveIdvector.isEmpty()){
					 //Log.v("=NOT===namevector1.isEmpty=", "=======================");
				 GlobalValues.dis_approveIdvector.removeAllElements();
			}
				if(!GlobalValues.dis_approvenamevector.isEmpty()){
					 //Log.v("=NOT===boysvector2.isEmpty=", "=======================");
					GlobalValues.dis_approvenamevector.removeAllElements();
				 }
				if(!GlobalValues.dis_approveboysvector.isEmpty()){
					 //Log.v("=NOT===girlsvector3.isEmpty=", "=======================");
					GlobalValues.dis_approveboysvector.removeAllElements();
				 }
				if(!GlobalValues.dis_approvegirlsvector.isEmpty()){
					 //Log.v("=NOT===datevector4.isEmpty=", "=======================");
					GlobalValues.dis_approvegirlsvector.removeAllElements();
				 }
				 if(!GlobalValues.dis_approvecityvector.isEmpty()){
					 //Log.v("=NOT===Idvector5.isEmpty=", "=======================");
					 GlobalValues.dis_approvecityvector.removeAllElements();
				 }
				 if(!GlobalValues.dis_approvalvector.isEmpty()){
					 //Log.v("=NOT===Idvector5.isEmpty=", "attendeddatecounter");
					 GlobalValues.dis_approvalvector.removeAllElements();
				 }
				 if(!GlobalValues.dis_approvesortdatevector.isEmpty()){
					 //Log.v("=NOT===Idvector5.isEmpty=", "approvesectionvector");
					 GlobalValues.dis_approvesortdatevector.removeAllElements();
				 }
				 if(!GlobalValues.dis_approvetimevector.isEmpty()){
					 //Log.v("=NOT===Idvector5.isEmpty=", "approvesectionvector");
					 GlobalValues.dis_approvetimevector.removeAllElements();
				 }
				 if(!GlobalValues.dis_approvemobileno.isEmpty()){
					 //Log.v("=NOT===Idvector5.isEmpty=", "approvesectionvector");
					 GlobalValues.dis_approvemobileno.removeAllElements();
				 }
				 if(!GlobalValues.globaldis_approvedate.isEmpty()){
					 //Log.v("=NOT===Idvector5.isEmpty=", "approvesectionvector");
					 GlobalValues.globaldis_approvedate.removeAllElements();
				 }
			
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try {
				//Log.i("counter doInBackground", "" + counter );
				
				counter = 0;
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(Constants.url+"/music_admin/display_guestlist");
				// Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("outlet_id", getoutletid));
                nameValuePairs.add(new BasicNameValuePair("access_token", ""+pref.getString("access_token", "no access_token")));
    
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				 // Execute HTTP Post Request
				 HttpResponse response = httpclient.execute(httppost);
				 HttpResponse httpResponse = httpclient.execute(httppost);
				    
				 if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					result3 = EntityUtils.toString(httpResponse.getEntity());
					//Log.v("display_guestlist ", "" + result3);
						
                    	JSONObject mjsonobj = new JSONObject(result3);
						Log.v("status", "" + mjsonobj.getString("status"));
						String status = "" + mjsonobj.getString("status");
						
						if(status.equalsIgnoreCase("true")){
						//Log.v("msg", "" + mjsonobj.getString("msg"));
						String mssg = "" + mjsonobj.getString("msg");
                    	
    					JSONArray jarray = new JSONArray(mssg);
    					//Log.v("length", ""+jarray.length());
    					for (int i = 0; i < jarray.length(); i++) {
    						
    						String id = jarray.getJSONObject(i).getString("guest_list_id");
    						String name = jarray.getJSONObject(i).getString("username");
    						String no_persons = jarray.getJSONObject(i).getString("boys");
    						String no_persons2 = jarray.getJSONObject(i).getString("girls");
    						String city = jarray.getJSONObject(i).getString("city");
    						String approval = jarray.getJSONObject(i).getString("approval");
    						String mobileno = jarray.getJSONObject(i).getString("mobile_number");
    						String guest_date = jarray.getJSONObject(i).getString("guest_time").substring(0, 10);
    						String guest_time = jarray.getJSONObject(i).getString("guest_time").substring(11, 16);
    						
    						/*Log.v("-----------------------", "---------------------");
    						Log.v("id", ""+id);
    						Log.v("name", ""+name);
    						Log.v("no_persons boys", ""+no_persons);
    						Log.v("no_persons2 girls", ""+no_persons2);
    						Log.v("city", ""+city);
    						Log.v("approval", ""+approval);
    						Log.v("guest_time", ""+guest_time);
    						Log.v("guest_date", ""+guest_date);
    						Log.v("mobileno", ""+mobileno);
    						Log.v("-----------------------", "---------------------");*/
    						 
    						globalvector.add(id.trim());
    						globalvector1.add(name.trim());
    						globalvector2.add(no_persons.trim());
    						globalvector3.add(no_persons2.trim());
    						globalvector4.add(city.trim());
    						globalvector5.add(approval.trim());
    						globalvector6.add(guest_time.trim());
    						globalvector7.add(guest_date.trim());
    						globalvector_mobno.add(mobileno.trim());
    						
    						if (!global_date_arryist.contains(guest_date.trim())) {
	                    		global_date_arryist.add(guest_date.trim());
	                    		GlobalValues.globaldis_approvedate.add(guest_date.trim());
	                    	}
    						
    						if(approval.equalsIgnoreCase("1")){
    							approved_globalvector.add(id.trim());
    							approved_globalvector1.add(name.trim());
    							approved_globalvector2.add(no_persons.trim());
    							approved_globalvector3.add(no_persons2.trim());
    							approved_globalvector4.add(city.trim());
    							approved_globalvector5.add(approval.trim());
    							approved_globalvector6.add(guest_time.trim());
    							approved_globalvector7.add(guest_date.trim());
    							approved_globalvector_mobno.add(mobileno.trim());
    						}
    						
    						if(approval.contains("2")){
    							GlobalValues.dis_approveIdvector.add(id.trim());
    							GlobalValues.dis_approvenamevector.add(name.trim());
    							GlobalValues.dis_approveboysvector.add(no_persons.trim());
    							GlobalValues.dis_approvegirlsvector.add(no_persons2.trim());
    							GlobalValues.dis_approvecityvector.add(city.trim());
    							GlobalValues.dis_approvalvector.add(approval.trim());
    							GlobalValues.dis_approvesortdatevector.add(guest_date.trim());
    							GlobalValues.dis_approvetimevector.add(guest_time.trim());
    							GlobalValues.dis_approvemobileno.add(mobileno.trim());
    						}
    						
    						if(approval.equalsIgnoreCase("3")){
    							attend_globalvector.add(id.trim());
    							attend_globalvector1.add(name.trim());
    							attend_globalvector2.add(no_persons.trim());
    							attend_globalvector3.add(no_persons2.trim());
    							attend_globalvector4.add(city.trim());
    							attend_globalvector5.add(approval.trim());
    							attend_globalvector6.add(guest_time.trim());
    							attend_globalvector7.add(guest_date.trim());
    							attend_globalvector_mobno.add(mobileno.trim());
    						}
    						 
    					}
    					 //=================================================================================================
	                     //=================================================================================================
    					 //==================================================================================================
    					Collections.sort(global_date_arryist);
    					Collections.sort(GlobalValues.globaldis_approvedate);
    					
		                 firstdate = ""+global_date_arryist.get(0);
	                     lastdate = ""+global_date_arryist.get(global_date_arryist.size()-1);
	                    	
	                     Log.v("firstdate", ""+firstdate);
	                     Log.v("lastdate", ""+lastdate);
	                     
	                     open_counter = globalvector7.size();
	                     Log.v("open_counter", ""+open_counter);
						
	                     for(int i=0; i<globalvector7.size(); i++){
							    
	                    	 if(globalvector7.elementAt(i).trim().equalsIgnoreCase(firstdate.trim()))
							    {               
							    	String idx = Integer.toString(i);
							        //Log.v("globalvector6.elementAt(i)",""+globalvector6.elementAt(i));
							        //Log.v("firstElement ",""+firstElement);
							        int index = Integer.parseInt(idx);
							        //Log.v("index",""+index);
							        String id = ""+globalvector.elementAt(index);
		    						String name = ""+globalvector1.elementAt(index);
		    						String no_persons =""+globalvector2.elementAt(index);
		    						String no_persons2 = ""+globalvector3.elementAt(index);
		    						String city = ""+globalvector4.elementAt(index);
		    						String approval = ""+globalvector5.elementAt(index);
		    						String guest_time = ""+globalvector6.elementAt(index);
		    						String guest_date = ""+globalvector7.elementAt(index);
		    						String mobileno = ""+globalvector_mobno.elementAt(index);
		    						
		    						if(approval.equalsIgnoreCase("0")){
		    						  /* Log.v("-----------------------", "---------------------");
		    						   Log.v("id", ""+id);
		    						   Log.v("name", ""+name);
		    						   Log.v("no_persons boys", ""+no_persons);
		    						   Log.v("no_persons2 girls", ""+no_persons2);
		    						   Log.v("city", ""+city);
		    						   Log.v("approval", ""+approval);
		    						   Log.v("guest_time", ""+guest_time);
		    						   Log.v("guest_date", ""+guest_date);
		    						   Log.v("mobileno", ""+mobileno);
		    						   Log.v("-----------------------", "---------------------");*/
		    						   
		    						   open_globalvector.add(id.trim());
		    						   open_globalvector1.add(name.trim());
		    						   open_globalvector2.add(no_persons.trim());
		    						   open_globalvector3.add(no_persons2.trim());
		    						   open_globalvector4.add(city.trim());
		    						   open_globalvector5.add(approval.trim());
		    						   open_globalvector6.add(guest_time.trim());
		    						   open_globalvector7.add(guest_date.trim());
		    						   open_globalvector_mobno.add(mobileno.trim());
		    						   
		    						}
							    }
							}
					
	                     //=================================================================================================
	                     //=================================================================================================
	                     
	                     approve_counter = approved_globalvector7.size();
	                     Log.v("approve_counter", ""+approve_counter);
						
	                     for(int i=0; i<approved_globalvector7.size(); i++){
							    if(approved_globalvector7.elementAt(i).trim().equalsIgnoreCase(firstdate.trim()))
							    {               
							    	String idx = Integer.toString(i);
							        //Log.v("globalvector6.elementAt(i)",""+globalvector6.elementAt(i));
							        //Log.v("firstElement ",""+firstElement);
							        int index = Integer.parseInt(idx);
							        //Log.v("index",""+index);
							        String id = ""+approved_globalvector.elementAt(index);
		    						String name = ""+approved_globalvector1.elementAt(index);
		    						String no_persons =""+approved_globalvector2.elementAt(index);
		    						String no_persons2 = ""+approved_globalvector3.elementAt(index);
		    						String city = ""+approved_globalvector4.elementAt(index);
		    						String approval = ""+approved_globalvector5.elementAt(index);
		    						String guest_time = ""+approved_globalvector6.elementAt(index);
		    						String guest_date = ""+approved_globalvector7.elementAt(index);
		    						String mobileno = ""+approved_globalvector_mobno.elementAt(index);
		    						
		    						  /* Log.v("-----------------------", "---------------------");
		    						   Log.v("id", ""+id);
		    						   Log.v("name", ""+name);
		    						   Log.v("no_persons boys", ""+no_persons);
		    						   Log.v("no_persons2 girls", ""+no_persons2);
		    						   Log.v("city", ""+city);
		    						   Log.v("approval", ""+approval);
		    						   Log.v("guest_time", ""+guest_time);
		    						   Log.v("guest_date", ""+guest_date);
		    						   Log.v("mobileno", ""+mobileno);
		    						   Log.v("-----------------------", "---------------------");*/
		    						   
		    							xapproved_globalvector.add(id.trim());
		    							xapproved_globalvector1.add(name.trim());
		    							xapproved_globalvector2.add(no_persons.trim());
		    							xapproved_globalvector3.add(no_persons2.trim());
		    							xapproved_globalvector4.add(city.trim());
		    							xapproved_globalvector5.add(approval.trim());
		    							xapproved_globalvector6.add(guest_time.trim());
		    							xapproved_globalvector7.add(guest_date.trim());
		    							xapproved_globalvector_mobno.add(mobileno.trim());
		    						
							    }
							}
	                     //=================================================================================================
	                     //=================================================================================================
	                     
	                     
	                     attend_counter = attend_globalvector7.size();
	                     Log.v("approve_counter", ""+attend_counter);
	                     
	                     for(int i=0; i<attend_globalvector7.size(); i++){
							    if(attend_globalvector7.elementAt(i).trim().equalsIgnoreCase(firstdate.trim()))
							    {               
							    	String idx = Integer.toString(i);
							        //Log.v("globalvector6.elementAt(i)",""+globalvector6.elementAt(i));
							        //Log.v("firstElement ",""+firstElement);
							        int index = Integer.parseInt(idx);
							        //Log.v("index",""+index);
							        String id = ""+attend_globalvector.elementAt(index);
		    						String name = ""+attend_globalvector1.elementAt(index);
		    						String no_persons =""+attend_globalvector2.elementAt(index);
		    						String no_persons2 = ""+attend_globalvector3.elementAt(index);
		    						String city = ""+attend_globalvector4.elementAt(index);
		    						String approval = ""+attend_globalvector5.elementAt(index);
		    						String guest_time = ""+attend_globalvector6.elementAt(index);
		    						String guest_date = ""+attend_globalvector7.elementAt(index);
		    						String mobileno = ""+attend_globalvector_mobno.elementAt(index);
		    						
		    						  /* Log.v("-----------------------", "---------------------");
		    						   Log.v("id", ""+id);
		    						   Log.v("name", ""+name);
		    						   Log.v("no_persons boys", ""+no_persons);
		    						   Log.v("no_persons2 girls", ""+no_persons2);
		    						   Log.v("city", ""+city);
		    						   Log.v("approval", ""+approval);
		    						   Log.v("guest_time", ""+guest_time);
		    						   Log.v("guest_date", ""+guest_date);
		    						   Log.v("mobileno", ""+mobileno);
		    						   Log.v("-----------------------", "---------------------");*/
		    						   
		    							xattend_globalvector.add(id.trim());
		    							xattend_globalvector1.add(name.trim());
		    							xattend_globalvector2.add(no_persons.trim());
		    							xattend_globalvector3.add(no_persons2.trim());
		    							xattend_globalvector4.add(city.trim());
		    							xattend_globalvector5.add(approval.trim());
		    							xattend_globalvector6.add(guest_time.trim());
		    							xattend_globalvector7.add(guest_date.trim());
		    							xattend_globalvector_mobno.add(mobileno.trim());
		    						
							    }
							}
	                     
						}
					
				 }else{
					 
					 
				 }
				    
				    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.v("Exception_guestlist ", "" + e.toString());
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			Log.i("Async-Example", "onPostExecute Called");
			simpleWaitDialog.dismiss();
			
			greateractionbartv.setText(""+Constants.convertDateformat(firstdate));
			
			Log.i("greateractionbartv", ""+Constants.convertDateformat(firstdate));
			
			rowItems = new ArrayList<RowItem2>();
			 
			 for (int i = 0; i < open_globalvector.size(); i++) {
				 RowItem2 item = new RowItem2(open_globalvector1.elementAt(i), open_globalvector2.elementAt(i)
		        			        ,open_globalvector3.elementAt(i),open_globalvector4.elementAt(i),open_globalvector.elementAt(i));
		         rowItems.add(item);
		        }
			 
			 listview.setOffsetLeft(xwidth); // left side offset
			 listview.setOffsetRight(xwidth); // right side offset
			 listview.setAnimationTime(0);
			
			 int sizes = open_globalvector.size();
			 
			 for(int i=1; i < sizes+1; i++){
				 answers.add(""+i);
			 }
			
			 CustomguestList adapter = new CustomguestList(getActivity(),R.layout.guest_list, rowItems,open_globalvector,open_globalvector1,open_globalvector2,
					 open_globalvector3,open_globalvector4,open_globalvector5,open_globalvector6,open_globalvector7,open_globalvector_mobno,answers);
			 listview.setAdapter(adapter);
			 
			 
			 listview.setSwipeListViewListener(new BaseSwipeListViewListener() {
		           
		           /* @Override
					public int onChangeSwipeMode(int position) {
						// TODO Auto-generated method stub
		            	//Log.d("onChangeSwipeMode position", ""+position);
		            	String xyz = ""+songapprovevector.elementAt(position);
		            	//Log.v("songapprovevector", ""+songapprovevector.elementAt(position));
		            	//Log.v("date_textview", ""+date_textview.getText());
		            	
		            	String date2 = ""+date_textview.getText();
		            	//Log.v("convertDate", ""+Constants.convertDate(date2));
		            	
		            	if(!songs_lastdate.equalsIgnoreCase(""+Constants.convertDate(date2))){
		            		return SwipeListView.SWIPE_MODE_NONE;
		            	}if(!xyz.equalsIgnoreCase("0")){
		            		return SwipeListView.SWIPE_MODE_NONE;
		            	}else{
		            		return SwipeListView.SWIPE_MODE_BOTH;
		            	}
					}*/
		        });
			 
			//====================================================================================================================
			//===================================================================================================================
			//===================================================================================================================
			//===================================================================================================================
			 
			 rowItems3 = new ArrayList<RowItem3>();
				for (int i = 0; i < xapproved_globalvector.size(); i++) {
					//Log.i("all data", ""+GlobalValues.globalvector.elementAt(i));
					RowItem3 item3 = new RowItem3(xapproved_globalvector.elementAt(i), xapproved_globalvector1.elementAt(i)
  			        ,xapproved_globalvector2.elementAt(i),xapproved_globalvector3.elementAt(i),xapproved_globalvector4.elementAt(i));
	
					rowItems3.add(item3);
				}
					int sizes2 = xapproved_globalvector.size();
					
					 for(int i1=1; i1 < sizes2+1; i1++){
						 answers1.add(""+i1);
					 }
						
					CustomApproveList aprrovelist = new CustomApproveList(getActivity(),R.layout.approve_list,rowItems3,xapproved_globalvector,
							xapproved_globalvector1,xapproved_globalvector2,xapproved_globalvector3,xapproved_globalvector4,
							xapproved_globalvector5,xapproved_globalvector6,xapproved_globalvector7,xapproved_globalvector_mobno,answers1);
					
					approvelistview.setOffsetLeft(xwidth); // left side offset
					approvelistview.setOffsetRight(xwidth);
					approvelistview.setAnimationTime(0);
					approvelistview.setAdapter(aprrovelist); 
					//====================================================================================================================
					//===================================================================================================================
					//===================================================================================================================
					//===================================================================================================================
					 
					
					rowItems4 = new ArrayList<RowItem4>();
					
					for (int i = 0; i < xattend_globalvector.size(); i++) {
						RowItem4 item4 = new RowItem4(xattend_globalvector.elementAt(i), xattend_globalvector1.elementAt(i)
	        			        ,xattend_globalvector2.elementAt(i),xattend_globalvector3.elementAt(i),xattend_globalvector4.elementAt(i));
						rowItems4.add(item4);
					}
					
						int sizes3 = xattend_globalvector.size();
						 
						 for(int i1=1; i1 < sizes3+1; i1++){
							 answers2.add(""+i1);
						 }
						
						CustomDeclinelist declinelistadapter = new CustomDeclinelist(getActivity(),R.layout.decline_list,rowItems4,xattend_globalvector
								,xattend_globalvector1,xattend_globalvector2,xattend_globalvector3,xattend_globalvector4,xattend_globalvector5,
								xattend_globalvector6,xattend_globalvector7,xattend_globalvector_mobno,answers2);
						
						attendedlist.setOffsetLeft(xwidth); //left side offset
						attendedlist.setAnimationTime(0);
						attendedlist.setAdapter(declinelistadapter);
				
						
						
		}
		
	}
	
	
	
	
	public class CustomguestList extends ArrayAdapter<RowItem2>{

		Context context;
		RowItem2 rowItem;
		ViewHolder holder = null;
		private String id;
		private ProgressDialog simpleWaitDialog;
		String guestlist;
		String resultt;
		private List<RowItem2> mrowItems = new ArrayList<RowItem2>();
		HashSet<String> set = new HashSet<String>();
		
		Vector<String> vector = new Vector<String>();
		Vector<String> vector1 = new Vector<String>();
		Vector<String> vector2 = new Vector<String>();
		Vector<String> vector3 = new Vector<String>();
		Vector<String> vector4 = new Vector<String>();
		Vector<String> vector5 = new Vector<String>();
		Vector<String> vector6 = new Vector<String>();
		Vector<String> vector7 = new Vector<String>();
		
		Vector<String> vector8 = new Vector<String>();
		Vector<String> vector9 = new Vector<String>();
		/*Vector<String> Declinevector1 = new Vector<String>();
		Vector<String> Declinevector2 = new Vector<String>();
		Vector<String> Declinevector3 = new Vector<String>();
		Vector<String> Declinevector4 = new Vector<String>();*/
		SharedPreferences pref;
		Editor editor;
		String fonttwo = "foundation-icons.ttf";
	    Typeface tf = Typeface.createFromAsset(getContext().getAssets(), fonttwo);
		ArrayList<String> answersvector = new ArrayList<String>();
		
		 public CustomguestList(Context context, int textViewResourceId,final List<RowItem2> rowItems,
				 Vector<String> open_globalvector, Vector<String> open_globalvector1, Vector<String> open_globalvector2, 
				 Vector<String> open_globalvector3, Vector<String> open_globalvector4, Vector<String> open_globalvector5, 
				 Vector<String> open_globalvector6, Vector<String> open_globalvector7, Vector<String> open_globalvector_mobno, 
				 ArrayList<String> answers) 
		 {
			super(context, textViewResourceId,rowItems);
			// TODO Auto-generated constructor stub
			this.context = context;
			this.mrowItems = rowItems;
			this.vector = open_globalvector;
			this.vector1 = open_globalvector1;
			this.vector2 = open_globalvector2;
			this.vector3 = open_globalvector3;
			this.vector4 = open_globalvector4;
			this.vector5 = open_globalvector5;
			this.vector6 = open_globalvector6;
			this.vector7 = open_globalvector7;
			this.vector8 = open_globalvector_mobno;
			
			this.answersvector = answers;
			
			pref = PreferenceManager.getDefaultSharedPreferences(context); // 0 - for private mode;
		 }

		    private class ViewHolder {
		        ImageView imageView;
		        TextView txtTitle, call_guestcircle, open_mobileno;
		        TextView txtDesc;
		        TextView date;
		        TextView girls, guestcircletv , guestcity;
		        ImageView declinebtn;
		        ImageView btn;
		        RelativeLayout linelayout, front_viewsongs;
		        
		    }
		    public View getView(final int position, View convertView, ViewGroup parent) {
		    	//try {
		        	rowItem = getItem(position);
		        	
		        	LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		        	if (convertView == null) {
						
					    convertView = mInflater.inflate(R.layout.guest_list, null);
					    holder = new ViewHolder();
					    
					    holder.open_mobileno = (TextView) convertView.findViewById(R.id.guest_mobileno);
					    
					    holder.txtTitle = (TextView) convertView.findViewById(R.id.titlee);
					    holder.txtDesc = (TextView) convertView.findViewById(R.id.artisttsongs);
					    
					    holder.call_guestcircle = (TextView) convertView.findViewById(R.id.call_circle);
					    holder.call_guestcircle.setTypeface(tf);
					    
					    holder.guestcity = (TextView)convertView.findViewById(R.id.myguestViewplace);
					    holder.girls = (TextView) convertView.findViewById(R.id.girlss);
					    holder.declinebtn = (ImageView)convertView.findViewById(R.id.Declinebtn);
					    holder.btn = (ImageView)convertView.findViewById(R.id.approvebutton);
					    holder.guestcircletv = (TextView) convertView.findViewById(R.id.guestlistcircle);
					    
					    holder.front_viewsongs = (RelativeLayout)convertView.findViewById(R.id.mainguesfrontview);
					    
					    holder.declinebtn.setLayoutParams(new LinearLayout.LayoutParams(buttonwidth, LinearLayout.LayoutParams.MATCH_PARENT));
					    holder.btn.setLayoutParams(new LinearLayout.LayoutParams(buttonwidth, LinearLayout.LayoutParams.MATCH_PARENT));

					    convertView.setTag(holder);
					
		        	} else
						//Log.v("else", "else");
		        		
		        		
		        		
					    holder = (ViewHolder) convertView.getTag();
		 
		        	if(position % 2 == 0 ){
		        		 //holder.front_viewsongs.setBackgroundColor(Color.parseColor("##cccccc"));
		        		 holder.front_viewsongs.setBackgroundColor(Color.parseColor("#d6d6d6"));
		              }else{
		            	  holder.front_viewsongs.setBackgroundColor(Color.parseColor("#cccccc"));
		            	  //holder.front_viewsongs.setBackgroundColor(Color.parseColor("#d6d6d6"));
		              }
		        	
		        	holder.open_mobileno.setText(""+vector8.elementAt(position));
		        	
		        	holder.txtTitle.setText(""+vector1.elementAt(position));
		        	
		        	holder.girls.setText(""+vector3.elementAt(position));
		        	
		        	holder.txtDesc.setText(""+vector2.elementAt(position));
		        	
		        	holder.guestcity.setText(""+vector4.elementAt(position));
		        	
		        	holder.guestcircletv.setText(""+vector6.get(position));
		        	
		        	
		        	holder.btn.setTag(position);
					holder.btn.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							String approvevalue = ""+vector.elementAt(position);
							Log.v("approvevalue", approvevalue);
							Log.v("approvevalue", ""+vector5.elementAt(position));
							
							new SendApproveValue().execute(approvevalue.trim(),""+vector5.elementAt(position));
							
						}
					});
					
					holder.declinebtn.setTag(position);
			    	holder.declinebtn.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							try {
								String disapprovevalue = ""+vector.elementAt(position);
								Log.v("disapprovevalue", disapprovevalue);
								
								new SendDisApproveValue().execute(disapprovevalue.trim());
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								Log.v("declinBtnException", ""+e.toString());
							}
							
						}
					});
			    	
			    	
			    	holder.call_guestcircle.setTag(position);
			    	holder.call_guestcircle.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							if(holder.open_mobileno.getText().length() != 0){
								Log.v("open_mobileno ", ""+holder.open_mobileno.getText());
								Intent callIntent = new Intent(Intent.ACTION_CALL);
								callIntent.setData(Uri.parse("tel:"+""+holder.open_mobileno.getText()));
								startActivity(callIntent);
							}else{
								Constants.showtoast(context, "Mobile no not valid!");
							}
							
						}
					});
		        	
		 
		        return convertView;
		    }
		    
		    private class SendApproveValue extends AsyncTask<String, Void, String> {

		    	String check = "";
				@Override
				protected String doInBackground(String... param) {
					// TODO Auto-generated method stub
					
					Log.v("param", "= "+param[0]);
					Log.v("param1", "= "+param[1]);
					
					String approvevalue = ""+param[0];
					String approvevalue2 = ""+param[0];
					
					try{
						Log.i("OFFERS InBackground", "spreadsInBackground");
						HttpClient hc = new DefaultHttpClient();

						HttpPost postMethod = new HttpPost(Constants.url+"/music_admin/approve_guestlist");

						
						List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						nameValuePairs.add(new BasicNameValuePair("guest_id",approvevalue));
						nameValuePairs.add(new BasicNameValuePair("approval",approvevalue2));
						nameValuePairs.add(new BasicNameValuePair("access_token", ""+pref.getString("access_token", "no access_token")));

						
						postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));

						HttpResponse rp = hc.execute(postMethod);

						if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
							guestlist = EntityUtils.toString(rp.getEntity());
							Log.v("OFFERS OFFERS", "" + guestlist);
						     
		                    Log.v("Approve guestlist", ""+guestlist);
		                    JSONObject mjsonobj = new JSONObject(guestlist);
							
							Log.v("status", "" + mjsonobj.getString("status"));
							String status = "" + mjsonobj.getString("status");
							//{"status":"true","data":[{"msg":"Successfully Approved"}]}
							
							if(status.equalsIgnoreCase("true")){
								
								check = status;
							    Log.v("data", "" + mjsonobj.getString("data"));
							    final String mssg = "" + mjsonobj.getString("data");
							
							    resultt = mssg;
							    
							    JSONArray jsonarry = new JSONArray(mssg);
								
								for (int i = 0; i < jsonarry.length(); i++) {
									
									final String songapprovechk = ""+jsonarry.getJSONObject(i).getString("msg");
									getActivity().runOnUiThread(new Runnable() {

										public void run() {
												//Toast.makeText(getActivity(), songapprovechk, Toast.LENGTH_LONG).show();
												AppMsg.makeText((Activity) context, songapprovechk, AppMsg.STYLE_INFO).show();
												
										   }
										});
								}
							
							}else{
								Log.v("status", "" + mjsonobj.getString("status"));
								Log.v("data", "" + mjsonobj.getString("data"));
								getActivity().runOnUiThread(new Runnable() {

									public void run() {
											//Toast.makeText(getActivity(), songapprovechk, Toast.LENGTH_LONG).show();
											AppMsg.makeText((Activity) context, "some error occurs", AppMsg.STYLE_INFO).show();
											
									   }
									});
							}
		                   
						}else{
							guestlist = EntityUtils.toString(rp.getEntity());
							Log.v("Approve guestlist OFFERS", "" + guestlist);
				            Log.d("Approve guestlist JSON", "StatusCode "+rp.getStatusLine().getStatusCode());
				        }
						
					}catch(Exception e){
						System.out.println("display_menulist errr"+e.toString());
						 //simpleWaitDialog.dismiss();
					}
					
					return null;
				}
		    	
				@Override
				protected void onPreExecute() {
					Log.i("Async-Example", "onPreExecute Called");
					simpleWaitDialog = ProgressDialog.show(context,"Wait..", "Sending data");

				}
				@Override
				protected void onPostExecute(String result) {
					Log.i("Async-Example", "onPostExecute Called");
					simpleWaitDialog.dismiss();
					if(check.equalsIgnoreCase("true")){
						 new ImageDownloader2().execute();
					}
					 
					
				}
		    	
		    }
		    
		    
		    
		    private class SendDisApproveValue extends AsyncTask<String, Void, String> {

				private String disguestlist, check1;
				private CharSequence disresultt;
				@Override
				protected String doInBackground(String... param) {
					// TODO Auto-generated method stub
					Log.v("dis approve id param", "= "+param[0]);
					
					String approvevalue = ""+param[0];
					
					try{
						Log.i("OFFERS InBackground", "spreadsInBackground");
						HttpClient hc = new DefaultHttpClient();

						HttpPost postMethod = new HttpPost(Constants.url+"/music_admin/disapprove_guestlist");

						List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						nameValuePairs.add(new BasicNameValuePair("guest_id",approvevalue));
						nameValuePairs.add(new BasicNameValuePair("access_token", ""+pref.getString("access_token", "no access_token")));

						
						postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));

						HttpResponse rp = hc.execute(postMethod);

						if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
							disguestlist = EntityUtils.toString(rp.getEntity());
							Log.v("disguestlist OFFERS", "" + disguestlist);
						     
		                    Log.v("disguestlist guestlist", ""+disguestlist);
	                        JSONObject mjsonobj = new JSONObject(disguestlist);
							
							Log.v("status", "" + mjsonobj.getString("status"));
							String status = "" + mjsonobj.getString("status");
							
							
							if(status.equalsIgnoreCase("true")){
								check1 = status;
								Log.v("data", "" + mjsonobj.getString("data"));
								final String mssg = "" + mjsonobj.getString("data");
								
								disresultt = mssg;
								getActivity().runOnUiThread(new Runnable() {

									public void run() {
										if(mssg.contains("successfully disapproved")){
											Toast.makeText(getActivity(), "successfully disapproved", Toast.LENGTH_LONG).show();
										}
									}
											
								});
								
							}else{
								
								Log.v("data", "" + mjsonobj.getString("data"));
							}
							
						}else{
							disguestlist = EntityUtils.toString(rp.getEntity());
							Log.v("disguestlist guestlist OFFERS", "" + disguestlist);
				            Log.d("disguestlist guestlist JSON", "StatusCode "+rp.getStatusLine().getStatusCode());
				        }
						
						
					}catch(Exception e){
						System.out.println("display_menulist errr"+e.toString());
						 //simpleWaitDialog.dismiss();
					}
					
					
					return null;
				}
		    	
				@Override
				protected void onPreExecute() {
					Log.i("Async-Example", "onPreExecute Called");
					simpleWaitDialog = ProgressDialog.show(context,"Wait..", "Sending data");

				}
				@Override
				protected void onPostExecute(String result) {
					Log.i("Async-Example", "onPostExecute Called");
					simpleWaitDialog.dismiss();
					
					if(check1.equalsIgnoreCase("true")){
						new ImageDownloader2().execute();
					}
					 // new ImageDownloader2().execute();
					

				}
		    	
		    }


	}
	
	

	public class CustomApproveList extends ArrayAdapter<RowItem3>{
		
		Context context;
		RowItem3 rowItem3;
		ViewHolder holder = null;
		
		Vector<String> vector = new Vector<String>();
		Vector<String> vector1 = new Vector<String>();
		Vector<String> vector2 = new Vector<String>();
		Vector<String> vector3 = new Vector<String>();
		Vector<String> vector4 = new Vector<String>();
		Vector<String> vector5 = new Vector<String>();
		Vector<String> vector6 = new Vector<String>();
		Vector<String> vector7 = new Vector<String>();
		Vector<String> vector8 = new Vector<String>();
		
		Vector<String> idvectorapprov = new Vector<String>();
		private List<RowItem3> mrowItems = new ArrayList<RowItem3>();
		
		ArrayList<String> manswers1 = new ArrayList<String>();
		
		String fonttwo = "foundation-icons.ttf";
	    Typeface tf = Typeface.createFromAsset(getContext().getAssets(), fonttwo);

		public CustomApproveList(Context context, int textViewResourceId, List<RowItem3> objects, 
				Vector<String> xapproved_globalvector, Vector<String> xapproved_globalvector1, Vector<String> xapproved_globalvector2, 
				Vector<String> xapproved_globalvector3, Vector<String> xapproved_globalvector4, Vector<String> xapproved_globalvector5,
			Vector<String> xapproved_globalvector6, Vector<String> xapproved_globalvector7, 
			Vector<String> xapproved_globalvector_mobno, ArrayList<String> answers1) {
			super(context,  textViewResourceId, objects);
			// TODO Auto-generated constructor stub
			this.context = context;
			this.mrowItems = objects;
			this.vector = xapproved_globalvector;
			this.vector1 = xapproved_globalvector1;
			this.vector2 = xapproved_globalvector2;
			this.vector3 = xapproved_globalvector3;
			this.vector4 = xapproved_globalvector4;
			this.vector5 = xapproved_globalvector5;
			this.vector6 = xapproved_globalvector6;
			this.vector7 = xapproved_globalvector7;
			this.vector8 = xapproved_globalvector_mobno;
			this.manswers1 = answers1;
			
		}

		 private class ViewHolder {
		        
		        TextView data, approve_callcircle, approvedguest_circle;
		        TextView txtTitle;
		        TextView txtDesc;
		        TextView date;
		        TextView girls, approvecircle_value;
		        ImageView declinebtn, dis_approve;
		        RelativeLayout layout;
		    }
		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			try {
				rowItem3 = getItem(position);
				
				LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
				if (convertView == null) {
					 convertView = mInflater.inflate(R.layout.approve_list, null);
					 holder = new ViewHolder();
					 
					 holder.declinebtn = (ImageView)convertView.findViewById(R.id.approveDeclinebtn);
					 holder.dis_approve = (ImageView)convertView.findViewById(R.id.dis_approvebuttons);
					 holder.data = (TextView) convertView.findViewById(R.id.titlee1);
					 holder.txtTitle = (TextView) convertView.findViewById(R.id.datetext1);
					 holder.txtDesc = (TextView) convertView.findViewById(R.id.approvedgirlss);
					 holder.date = (TextView) convertView.findViewById(R.id.textView3);
					 holder.approvecircle_value = (TextView) convertView.findViewById(R.id.approveguestlistcircle);
					 holder.declinebtn.setLayoutParams(new LinearLayout.LayoutParams(buttonwidth, LinearLayout.LayoutParams.MATCH_PARENT));
					 holder.dis_approve.setLayoutParams(new LinearLayout.LayoutParams(buttonwidth, LinearLayout.LayoutParams.MATCH_PARENT));

					 holder.layout = (RelativeLayout)convertView.findViewById(R.id.mainguesfrontview);
					 
					 holder.approve_callcircle = (TextView)convertView.findViewById(R.id.approve_call);
					 holder.approve_callcircle.setTypeface(tf);
					 
					 holder.approvedguest_circle = (TextView) convertView.findViewById(R.id.attend_mobileno);
					 
					 convertView.setTag(holder);
					 
					
				}else
					//Log.v("else", "else");
				    holder = (ViewHolder) convertView.getTag();
				
				holder.approvedguest_circle.setText(""+vector8.elementAt(position));
				
				if(position % 2 == 0 ){
	        		 //holder.front_viewsongs.setBackgroundColor(Color.parseColor("##cccccc"));
	        		 holder.layout.setBackgroundColor(Color.parseColor("#d6d6d6"));
	              }else{
	            	  holder.layout.setBackgroundColor(Color.parseColor("#cccccc"));
	            	  //holder.front_viewsongs.setBackgroundColor(Color.parseColor("#d6d6d6"));
	              }
				
				    holder.data.setText(""+vector1.elementAt(position));
				    holder.txtTitle.setText(""+vector2.elementAt(position));
				    holder.txtDesc.setText(""+vector3.elementAt(position));
				    holder.date.setText(""+vector4.elementAt(position));
				    
				    holder.approvecircle_value.setText(vector6.get(position));
				    //String itemid = ""+rowItem3.getItemID();
				    //Log.v("itemid= ", itemid);
				    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.v("Exception= ", e.toString());
			}
			

			holder.declinebtn.setTag(position);
			holder.declinebtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						String approvevalue = ""+vector.elementAt(position);
						Log.v("APPROVE approvevalue", approvevalue);
						
						new SendattendValue().execute(approvevalue.trim());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						Log.v("attendedde Exception= ", e.toString());
					}
					
				}
			});
			//====================================================================================
			holder.dis_approve.setTag(position);
			holder.dis_approve.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						String approvevalue = ""+vector.elementAt(position);
						Log.v("APPROVE approvevalue", approvevalue);
						
						new SendDisApproveValue().execute(approvevalue.trim());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						Log.v("attendedde Exception= ", e.toString());
					}
					
				}
			});
	    	
			
			return convertView;
		}
		
		 private class SendDisApproveValue extends AsyncTask<String, Void, String> {

				private String disguestlist, check1;
				private CharSequence disresultt;
				@Override
				protected String doInBackground(String... param) {
					// TODO Auto-generated method stub
					Log.v("dis approve id param", "= "+param[0]);
					
					String approvevalue = ""+param[0];
					
					try{
						Log.i("OFFERS InBackground", "spreadsInBackground");
						HttpClient hc = new DefaultHttpClient();

						HttpPost postMethod = new HttpPost(Constants.url+"/music_admin/disapprove_guestlist");

						List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						nameValuePairs.add(new BasicNameValuePair("guest_id",approvevalue));
						nameValuePairs.add(new BasicNameValuePair("access_token", ""+pref.getString("access_token", "no access_token")));

						
						postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));

						HttpResponse rp = hc.execute(postMethod);

						if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
							disguestlist = EntityUtils.toString(rp.getEntity());
							Log.v("disguestlist OFFERS", "" + disguestlist);
						     
		                    Log.v("disguestlist guestlist", ""+disguestlist);
	                        JSONObject mjsonobj = new JSONObject(disguestlist);
							
							Log.v("status", "" + mjsonobj.getString("status"));
							String status = "" + mjsonobj.getString("status");
							
							
							if(status.equalsIgnoreCase("true")){
								check1 = status;
								Log.v("data", "" + mjsonobj.getString("data"));
								final String mssg = "" + mjsonobj.getString("data");
								
								disresultt = mssg;
								getActivity().runOnUiThread(new Runnable() {

									public void run() {
										if(mssg.contains("successfully disapproved")){
											Toast.makeText(getActivity(), "successfully disapproved", Toast.LENGTH_LONG).show();
										}
									}
											
								});
								
							}else{
								
								Log.v("data", "" + mjsonobj.getString("data"));
							}
							
						}else{
							disguestlist = EntityUtils.toString(rp.getEntity());
							Log.v("disguestlist guestlist OFFERS", "" + disguestlist);
				            Log.d("disguestlist guestlist JSON", "StatusCode "+rp.getStatusLine().getStatusCode());
				        }
						
						
					}catch(Exception e){
						System.out.println("display_menulist errr"+e.toString());
						 //simpleWaitDialog.dismiss();
					}
					
					return null;
				}
		    	
				@Override
				protected void onPreExecute() {
					Log.i("Async-Example", "onPreExecute Called");
					simpleWaitDialog = ProgressDialog.show(context,"Wait..", "Sending data");

				}
				@Override
				protected void onPostExecute(String result) {
					Log.i("Async-Example", "onPostExecute Called");
					simpleWaitDialog.dismiss();
					
					if(check1.equalsIgnoreCase("true")){
						new ImageDownloader2().execute();
					}
					 // new ImageDownloader2().execute();
				}
		    	
		    }
		
		private class SendattendValue extends AsyncTask<String, Void, String> {

			private String disguestlist, check1;
			private CharSequence disresultt;
			private ProgressDialog simpleWaitDialog;
			@Override
			protected String doInBackground(String... param) {
				// TODO Auto-generated method stub
				Log.v("dis approve id param", "= "+param[0]);
				
				String approvevalue = ""+param[0];
				
				try{
					Log.i("OFFERS InBackground", "spreadsInBackground");
					HttpClient hc = new DefaultHttpClient();

					//HttpPost postMethod = new HttpPost(Constants.url+"/music_admin/disapprove_guestlist");
					HttpPost postMethod = new HttpPost(Constants.url+"/music_admin/attend_guest");

					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					nameValuePairs.add(new BasicNameValuePair("guest_id",approvevalue));
					nameValuePairs.add(new BasicNameValuePair("access_token", ""+pref.getString("access_token", "no access_token")));

					
					postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));

					HttpResponse rp = hc.execute(postMethod);

					if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						disguestlist = EntityUtils.toString(rp.getEntity());
						Log.v("disguestlist OFFERS", "" + disguestlist);
					     
	                    Log.v("disguestlist guestlist", ""+disguestlist);
	                    JSONObject mjsonobj = new JSONObject(disguestlist);
						
						Log.v("status", "" + mjsonobj.getString("status"));
						String status = "" + mjsonobj.getString("status");
						//{"status":"true","data":[{"msg":"Successfully Approved"}]}
						
						if(status.equalsIgnoreCase("true")){
							check1 = status;
						Log.v("data", "" + mjsonobj.getString("data"));
						final String mssg = "" + mjsonobj.getString("data");
						//resultt = mssg;
						//{"status":"true","data":[{"msg":"successfully disapproved"}]}
						
						//[{"msg":"successfully saved"}]
						getActivity().runOnUiThread(new Runnable() {

							public void run() {
								if(mssg.contains("successfully saved")){
									Toast.makeText(getActivity(), "successfully saved", Toast.LENGTH_LONG).show();
								}
									
							   }
							});
	                   
						
						}else{
							Log.v("data", "" + mjsonobj.getString("data"));
						}
						//Log.v("msg", "" + mjsonobj.getString("msg"));
						//String mssg = "" + mjsonobj.getString("msg");
	                    
						//disresultt = mssg;
	                   /*JSONArray jarry = new JSONArray(mssg);
	                   for (int i = 0; i < jarry.length(); i++) {
						
	                	   disresultt = ""+jarry.getString(i);
	                	   Log.v("disguestlist resultt", ""+disresultt);
					
	                   } */

					}else{
						disguestlist = EntityUtils.toString(rp.getEntity());
						Log.v("disguestlist guestlist OFFERS", "" + disguestlist);
			            Log.d("disguestlist guestlist JSON", "StatusCode "+rp.getStatusLine().getStatusCode());
			        }
					
					
				}catch(Exception e){
					System.out.println("display_menulist errr"+e.toString());
					 //simpleWaitDialog.dismiss();
				}
				
				
				return null;
			}
	    	
			@Override
			protected void onPreExecute() {
				Log.i("Async-Example", "onPreExecute Called");
				simpleWaitDialog = ProgressDialog.show(context,"Wait..", "Sending data");

			}
			@Override
			protected void onPostExecute(String result) {
				Log.i("Async-Example", "onPostExecute Called");
				simpleWaitDialog.dismiss();
				if(check1.equalsIgnoreCase("true")){
					 new ImageDownloader2().execute();
				}
				 
				

			}
	    	
	    }

	}
	
	//============================================================================================

	public class CustomDeclinelist extends ArrayAdapter<RowItem4>{
		
		Context context;
		RowItem4 rowItem4;
		ViewHolder holder = null;
		ImageView approvebtn;
		Vector<String> vector = new Vector<String>();
		Vector<String> vector1 = new Vector<String>();
		Vector<String> vector2 = new Vector<String>();
		Vector<String> vector3 = new Vector<String>();
		Vector<String> vector4 = new Vector<String>();
		Vector<String> vector5 = new Vector<String>();
		Vector<String> vector6 = new Vector<String>();
		Vector<String> vector7 = new Vector<String>();
		Vector<String> vector8 = new Vector<String>();
		
		Vector<String> midvectordeclin = new Vector<String>();
		private List<RowItem4> mrowItems = new ArrayList<RowItem4>();
		public String guestlist;
		public String resultt;
		private ProgressDialog simpleWaitDialog;
		
		ArrayList<String> manswers = new ArrayList<String>();
		String fonttwo = "foundation-icons.ttf";
	    Typeface tf = Typeface.createFromAsset(getContext().getAssets(), fonttwo);

		public CustomDeclinelist(Context context, int declineList,List<RowItem4> rowItems4, Vector<String> xattend_globalvector,
				Vector<String> xattend_globalvector1, Vector<String> xattend_globalvector2, Vector<String> xattend_globalvector3,
				Vector<String> xattend_globalvector4, Vector<String> xattend_globalvector5, Vector<String> xattend_globalvector6, 
				Vector<String> xattend_globalvector7, Vector<String> xattend_globalvector_mobno, ArrayList<String> answers2) {
			super(context, declineList,rowItems4);
			// TODO Auto-generated constructor stub
			this.context = context;
			this.mrowItems = rowItems4;
			
			this.vector = xattend_globalvector;
			this.vector1 = xattend_globalvector1;
			this.vector2 = xattend_globalvector2;
			this.vector3 = xattend_globalvector3;
			this.vector4 = xattend_globalvector4;
			this.vector5 = xattend_globalvector5;
			this.vector6 = xattend_globalvector6;
			this.vector7 = xattend_globalvector7;
			this.vector8 = xattend_globalvector_mobno;
			this.manswers = answers2;
		}
		private class ViewHolder {
	        
	        TextView txtTitle, attende_callcircle, attendguest_mobileno;
	        TextView txtDesc;
	        TextView date;
	        TextView girls, declinelistcircle;
	        RelativeLayout layout;
	    }

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			try {
				rowItem4 = getItem(position);
				
				LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
				
				if (convertView == null) {
					 convertView = mInflater.inflate(R.layout.decline_list, null);
					 holder = new ViewHolder();
					
					 holder.txtTitle = (TextView) convertView.findViewById(R.id.Dtitlee1);
					 holder.txtDesc = (TextView) convertView.findViewById(R.id.DtextView1);
					 holder.date = (TextView) convertView.findViewById(R.id.DtextView3);
					 holder.girls = (TextView) convertView.findViewById(R.id.datetext1);
					 holder.layout = (RelativeLayout) convertView.findViewById(R.id.declineguesfrontview);
					 holder.declinelistcircle = (TextView) convertView.findViewById(R.id.declineguestlistcircle);
					 
					 holder.attende_callcircle = (TextView) convertView.findViewById(R.id.attended_call);
					 holder.attende_callcircle.setTypeface(tf);
					 
					 holder.attendguest_mobileno = (TextView) convertView.findViewById(R.id.attended_mobileno);
					 
					  convertView.setTag(holder);
					 
				}else
					//Log.v("else", "else");
				    holder = (ViewHolder) convertView.getTag();
				
				holder.attendguest_mobileno.setText(""+vector8.elementAt(position));
				
				if(position % 2 == 0 ){
	        		 //holder.front_viewsongs.setBackgroundColor(Color.parseColor("##cccccc"));
	        		 holder.layout.setBackgroundColor(Color.parseColor("#d6d6d6"));
	              }else{
	            	  holder.layout.setBackgroundColor(Color.parseColor("#cccccc"));
	            	  //holder.front_viewsongs.setBackgroundColor(Color.parseColor("#d6d6d6"));
	              }
				
				holder.txtTitle.setText(""+vector1.elementAt(position));
				holder.txtDesc.setText(""+vector2.elementAt(position));
				holder.date.setText(""+vector3.elementAt(position));
				holder.girls.setText(""+vector4.elementAt(position));
				
				holder.declinelistcircle.setText(vector6.get(position));
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.v("DeclinelistException", e.toString());
			}
			
			
			approvebtn = (ImageView)convertView.findViewById(R.id.Dbutton1);
			approvebtn.setLayoutParams(new LinearLayout.LayoutParams(buttonwidth, LinearLayout.LayoutParams.MATCH_PARENT));

			approvebtn.setTag(position);
			approvebtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//Toast.makeText(context, ""+ getItem(position), Toast.LENGTH_SHORT).show();
					try {
						String approvevalue = ""+vector.elementAt(position);
						Log.v("APPROVE approvevalue", approvevalue);
						Log.v("vector5.elementAt(position)", ""+vector5.elementAt(position));
						
						new SendApproveValue().execute(approvevalue.trim(),""+vector5.elementAt(position));
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						Log.v("approvebtn list Exception", e.toString());
					}
					
					
				}
			});
			
			return convertView;
		}
		
		private class SendApproveValue extends AsyncTask<String, Void, String> {

			String check1;
			@Override
			protected String doInBackground(String... param) {
				// TODO Auto-generated method stub
				
				Log.v("param", "= "+param[0]);
				
				String approvevalue = ""+param[0];
				String approvevalue2 = ""+param[0];
				
				try{
					Log.i("OFFERS InBackground", "spreadsInBackground");
					HttpClient hc = new DefaultHttpClient();

					HttpPost postMethod = new HttpPost(Constants.url+"/music_admin/approve_guestlist");

					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					nameValuePairs.add(new BasicNameValuePair("guest_id",approvevalue));
					nameValuePairs.add(new BasicNameValuePair("approval",approvevalue2));
					nameValuePairs.add(new BasicNameValuePair("access_token", ""+pref.getString("access_token", "no access_token")));

					
					postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));

					HttpResponse rp = hc.execute(postMethod);

					if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						guestlist = EntityUtils.toString(rp.getEntity());
						Log.v("OFFERS OFFERS", "" + guestlist);
					     
	                    Log.v("Approve guestlist", ""+guestlist);
	                    JSONObject mjsonobj = new JSONObject(guestlist);
						
						Log.v("status", "" + mjsonobj.getString("status"));
						String status = "" + mjsonobj.getString("status");
						//{"status":"true","data":[{"msg":"Successfully Approved"}]}
						
						if(status.equalsIgnoreCase("true")){
							check1 = status;
						Log.v("data", "" + mjsonobj.getString("data"));
						final String mssg = "" + mjsonobj.getString("data");
						//resultt = mssg;
						
						getActivity().runOnUiThread(new Runnable() {

							public void run() {
								if(mssg.contains("Successfully Approved")){
									Toast.makeText(getActivity(), "Successfully Approved", Toast.LENGTH_LONG).show();
								}
									
							   }
							});
	                   
						
						}else{
							Log.v("data", "" + mjsonobj.getString("data"));
						}
						
						
					}else{
						guestlist = EntityUtils.toString(rp.getEntity());
						Log.v("Approve guestlist OFFERS", "" + guestlist);
			            Log.d("Approve guestlist JSON", "StatusCode "+rp.getStatusLine().getStatusCode());
			        }
					
				}catch(Exception e){
					System.out.println("display_menulist errr"+e.toString());
					 //simpleWaitDialog.dismiss();
				}
				
				return null;
			}
	    	
			@Override
			protected void onPreExecute() {
				Log.i("Async-Example", "onPreExecute Called");
				simpleWaitDialog = ProgressDialog.show(context,"Wait..", "Sending data");

			}
			@Override
			protected void onPostExecute(String result) {
				Log.i("Async-Example", "onPostExecute Called");
				simpleWaitDialog.dismiss();
				if(check1.equalsIgnoreCase("true")){
					new ImageDownloader2().execute();
				}
				  //new ImageDownloader2().execute();

					
			}
	    	
	    }

	}
	
	@Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        // This does work
        MenuItem someMenuItem = menu.findItem(R.id.action_settings);
        someMenuItem.setVisible(false);
        someMenuItem.setEnabled(false);
    }
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		setHasOptionsMenu(true);
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		Log.v("onTabChanged tabId : ", ""+tabId);
		
		
	}
	
	
	
	protected void lessimageview() {
		// TODO Auto-generated method stub
		if(open_counter != 0){
		counter--;
		if(counter <= 0){
			counter = 0;
		}
		Log.v("guest_counter : ", ""+counter);
		Log.v("global_date_arryist lessimageview ", ""+global_date_arryist.get(counter));
		if(!open_globalvector.isEmpty()){
			open_globalvector.removeAllElements();
		     
		}
		if(!open_globalvector1.isEmpty()){
			open_globalvector1.removeAllElements();
		     
		}
		if(!open_globalvector2.isEmpty()){
			open_globalvector2.removeAllElements();
		     
		}
		if(!open_globalvector3.isEmpty()){
			open_globalvector3.removeAllElements();
		     
		}
		if(!open_globalvector4.isEmpty()){
			open_globalvector4.removeAllElements();
		     
		}
		
		if(!open_globalvector5.isEmpty()){
			open_globalvector5.removeAllElements();
		     
		}
		if(!open_globalvector6.isEmpty()){
			open_globalvector6.removeAllElements();
		     
		}
		if(!open_globalvector7.isEmpty()){
			open_globalvector7.removeAllElements();
		     
		}
		if(!open_globalvector_mobno.isEmpty()){
			open_globalvector_mobno.removeAllElements();
		     
		}
		if(!answers.isEmpty()){
			answers.clear();
		     
		}
		
		greateractionbartv.setText(""+Constants.convertDateformat(""+global_date_arryist.get(counter).trim()));
		
		Log.i("greateractionbartv", ""+Constants.convertDateformat(""+global_date_arryist.get(counter).trim()));
		
		for(int i=0; i<globalvector7.size(); i++){
		    if(globalvector7.elementAt(i).trim().equalsIgnoreCase( ""+global_date_arryist.get(counter).trim()))
		    {               
		    	String idx = Integer.toString(i);
		        //Log.v("globalvector6.elementAt(i)",""+globalvector6.elementAt(i));
		        //Log.v("firstElement ",""+firstElement);
		        int index = Integer.parseInt(idx);
		        //Log.v("index",""+index);
		        String id = ""+globalvector.elementAt(index);
				String name = ""+globalvector1.elementAt(index);
				String no_persons =""+globalvector2.elementAt(index);
				String no_persons2 = ""+globalvector3.elementAt(index);
				String city = ""+globalvector4.elementAt(index);
				String approval = ""+globalvector5.elementAt(index);
				String guest_time = ""+globalvector6.elementAt(index);
				String guest_date = ""+globalvector7.elementAt(index);
				String mobileno = ""+globalvector_mobno.elementAt(index);
				
				if(approval.equalsIgnoreCase("0")){
				  /* Log.v("-----------------------", "---------------------");
				   Log.v("id", ""+id);
				   Log.v("name", ""+name);
				   Log.v("no_persons boys", ""+no_persons);
				   Log.v("no_persons2 girls", ""+no_persons2);
				   Log.v("city", ""+city);
				   Log.v("approval", ""+approval);
				   Log.v("guest_time", ""+guest_time);
				   Log.v("guest_date", ""+guest_date);
				   Log.v("mobileno", ""+mobileno);
				   Log.v("-----------------------", "---------------------");*/
				   
				   open_globalvector.add(id.trim());
				   open_globalvector1.add(name.trim());
				   open_globalvector2.add(no_persons.trim());
				   open_globalvector3.add(no_persons2.trim());
				   open_globalvector4.add(city.trim());
				   open_globalvector5.add(approval.trim());
				   open_globalvector6.add(guest_time.trim());
				   open_globalvector7.add(guest_date.trim());
				   open_globalvector_mobno.add(mobileno.trim());
				   
				   
				}
		    }
		}
		rowItems = new ArrayList<RowItem2>();
		 
		 for (int i = 0; i < open_globalvector.size(); i++) {
			 RowItem2 item = new RowItem2(open_globalvector1.elementAt(i), open_globalvector2.elementAt(i)
	        			        ,open_globalvector3.elementAt(i),open_globalvector4.elementAt(i),open_globalvector.elementAt(i));
	         rowItems.add(item);
	        }
		 
		 listview.setOffsetLeft(xwidth); // left side offset
		 listview.setOffsetRight(xwidth); // right side offset
		 listview.setAnimationTime(0);
		
		 int sizes = open_globalvector.size();
		 
		 for(int i=1; i < sizes+1; i++){
			 answers.add(""+i);
		 }
		
		 CustomguestList adapter = new CustomguestList(getActivity(),R.layout.guest_list, rowItems,open_globalvector,open_globalvector1,open_globalvector2,
				 open_globalvector3,open_globalvector4,open_globalvector5,open_globalvector6,open_globalvector7,open_globalvector_mobno,answers);
		 listview.setAdapter(adapter);
		
		
		}
		//===================================================================================================
		//===================================================================================================
		//===================================================================================================
		//===================================================================================================
		if(!xapproved_globalvector.isEmpty()){
			xapproved_globalvector.removeAllElements();
		     
		}
		if(!xapproved_globalvector1.isEmpty()){
			xapproved_globalvector1.removeAllElements();
		     
		}
		if(!xapproved_globalvector2.isEmpty()){
			xapproved_globalvector2.removeAllElements();
		     
		}
		if(!xapproved_globalvector3.isEmpty()){
			xapproved_globalvector3.removeAllElements();
		     
		}
		if(!xapproved_globalvector4.isEmpty()){
			xapproved_globalvector4.removeAllElements();
		     
		}
		
		if(!xapproved_globalvector5.isEmpty()){
			xapproved_globalvector5.removeAllElements();
		     
		}
		if(!xapproved_globalvector6.isEmpty()){
			xapproved_globalvector6.removeAllElements();
		     
		}
		if(!xapproved_globalvector7.isEmpty()){
			xapproved_globalvector7.removeAllElements();
		     
		}
		if(!xapproved_globalvector_mobno.isEmpty()){
			xapproved_globalvector_mobno.removeAllElements();
		}
		if(!answers1.isEmpty()){
			answers1.clear();
		}
		
		for(int i=0; i<approved_globalvector7.size(); i++){
		    if(approved_globalvector7.elementAt(i).trim().equalsIgnoreCase( ""+global_date_arryist.get(counter).trim()))
		    {               
		    	String idx = Integer.toString(i);
		        //Log.v("globalvector6.elementAt(i)",""+globalvector6.elementAt(i));
		        //Log.v("firstElement ",""+firstElement);
		        int index = Integer.parseInt(idx);
		        //Log.v("index",""+index);
		        String id = ""+approved_globalvector.elementAt(index);
				String name = ""+approved_globalvector1.elementAt(index);
				String no_persons =""+approved_globalvector2.elementAt(index);
				String no_persons2 = ""+approved_globalvector3.elementAt(index);
				String city = ""+approved_globalvector4.elementAt(index);
				String approval = ""+approved_globalvector5.elementAt(index);
				String guest_time = ""+approved_globalvector6.elementAt(index);
				String guest_date = ""+approved_globalvector7.elementAt(index);
				String mobileno = ""+approved_globalvector_mobno.elementAt(index);
				
				if(approval.equalsIgnoreCase("1")){
				  /* Log.v("-----------------------", "---------------------");
				   Log.v("id", ""+id);
				   Log.v("name", ""+name);
				   Log.v("no_persons boys", ""+no_persons);
				   Log.v("no_persons2 girls", ""+no_persons2);
				   Log.v("city", ""+city);
				   Log.v("approval", ""+approval);
				   Log.v("guest_time", ""+guest_time);
				   Log.v("guest_date", ""+guest_date);
				   Log.v("mobileno", ""+mobileno);
				   Log.v("-----------------------", "---------------------");*/
				   
					xapproved_globalvector.add(id.trim());
					xapproved_globalvector1.add(name.trim());
					xapproved_globalvector2.add(no_persons.trim());
					xapproved_globalvector3.add(no_persons2.trim());
					xapproved_globalvector4.add(city.trim());
					xapproved_globalvector5.add(approval.trim());
					xapproved_globalvector6.add(guest_time.trim());
					xapproved_globalvector7.add(guest_date.trim());
					xapproved_globalvector_mobno.add(mobileno.trim());
				   
				}
		    }
		}
		    rowItems3 = new ArrayList<RowItem3>();
			for (int i1 = 0; i1 < xapproved_globalvector.size(); i1++) {
				//Log.i("all data", ""+GlobalValues.globalvector.elementAt(i));
				RowItem3 item3 = new RowItem3(xapproved_globalvector.elementAt(i1), xapproved_globalvector1.elementAt(i1)
			        ,xapproved_globalvector2.elementAt(i1),xapproved_globalvector3.elementAt(i1),xapproved_globalvector4.elementAt(i1));

				rowItems3.add(item3);
			}
				int sizes2 = xapproved_globalvector.size();
				
				 for(int i1=1; i1 < sizes2+1; i1++){
					 answers1.add(""+i1);
				 }
					
				CustomApproveList aprrovelist = new CustomApproveList(getActivity(),R.layout.approve_list,rowItems3,xapproved_globalvector,
						xapproved_globalvector1,xapproved_globalvector2,xapproved_globalvector3,xapproved_globalvector4,
						xapproved_globalvector5,xapproved_globalvector6,xapproved_globalvector7,xapproved_globalvector_mobno,answers1);
				
				approvelistview.setOffsetLeft(xwidth); // left side offset
				approvelistview.setAnimationTime(0);
				approvelistview.setAdapter(aprrovelist);
				//===================================================================================================
				//===================================================================================================
				//===================================================================================================
			   //===================================================================================================  
		    
				if(!xattend_globalvector.isEmpty()){
					xattend_globalvector.removeAllElements();
				     
				}
				if(!xattend_globalvector1.isEmpty()){
					xattend_globalvector1.removeAllElements();
				     
				}
				if(!xattend_globalvector2.isEmpty()){
					xattend_globalvector2.removeAllElements();
				     
				}
				if(!xattend_globalvector3.isEmpty()){
					xattend_globalvector3.removeAllElements();
				     
				}
				if(!xattend_globalvector4.isEmpty()){
					xattend_globalvector4.removeAllElements();
				     
				}
				
				if(!xattend_globalvector5.isEmpty()){
					xattend_globalvector5.removeAllElements();
				     
				}
				if(!xattend_globalvector6.isEmpty()){
					xattend_globalvector6.removeAllElements();
				     
				}
				if(!xattend_globalvector7.isEmpty()){
					xattend_globalvector7.removeAllElements();
				     
				}
				if(!xattend_globalvector_mobno.isEmpty()){
					xattend_globalvector_mobno.removeAllElements();
				}
				if(!answers2.isEmpty()){
					answers2.clear();
				     
				}
				
				for(int i=0; i<attend_globalvector7.size(); i++){
				    if(attend_globalvector7.elementAt(i).trim().equalsIgnoreCase( ""+global_date_arryist.get(counter).trim()))
				    {               
				    	String idx = Integer.toString(i);
				        //Log.v("globalvector6.elementAt(i)",""+globalvector6.elementAt(i));
				        //Log.v("firstElement ",""+firstElement);
				        int index = Integer.parseInt(idx);
				        //Log.v("index",""+index);
				        String id = ""+attend_globalvector.elementAt(index);
						String name = ""+attend_globalvector1.elementAt(index);
						String no_persons =""+attend_globalvector2.elementAt(index);
						String no_persons2 = ""+attend_globalvector3.elementAt(index);
						String city = ""+attend_globalvector4.elementAt(index);
						String approval = ""+attend_globalvector5.elementAt(index);
						String guest_time = ""+attend_globalvector6.elementAt(index);
						String guest_date = ""+attend_globalvector7.elementAt(index);
						String mobileno = ""+attend_globalvector_mobno.elementAt(index);
						
						  /* Log.v("-----------------------", "---------------------");
						   Log.v("id", ""+id);
						   Log.v("name", ""+name);
						   Log.v("no_persons boys", ""+no_persons);
						   Log.v("no_persons2 girls", ""+no_persons2);
						   Log.v("city", ""+city);
						   Log.v("approval", ""+approval);
						   Log.v("guest_time", ""+guest_time);
						   Log.v("guest_date", ""+guest_date);
						   Log.v("mobileno", ""+mobileno);
						   Log.v("-----------------------", "---------------------");*/
						   
							xattend_globalvector.add(id.trim());
							xattend_globalvector1.add(name.trim());
							xattend_globalvector2.add(no_persons.trim());
							xattend_globalvector3.add(no_persons2.trim());
							xattend_globalvector4.add(city.trim());
							xattend_globalvector5.add(approval.trim());
							xattend_globalvector6.add(guest_time.trim());
							xattend_globalvector7.add(guest_date.trim());
							xattend_globalvector_mobno.add(mobileno.trim());
						
				    }
				}	
				rowItems4 = new ArrayList<RowItem4>();
				
				for (int i = 0; i < xattend_globalvector.size(); i++) {
					RowItem4 item4 = new RowItem4(xattend_globalvector.elementAt(i), xattend_globalvector1.elementAt(i)
        			        ,xattend_globalvector2.elementAt(i),xattend_globalvector3.elementAt(i),xattend_globalvector4.elementAt(i));
					rowItems4.add(item4);
				}
				
					int sizes3 = xattend_globalvector.size();
					 
					 for(int i1=1; i1 < sizes3+1; i1++){
						 answers2.add(""+i1);
					 }
					
					CustomDeclinelist declinelistadapter = new CustomDeclinelist(getActivity(),R.layout.decline_list,rowItems4,xattend_globalvector
							,xattend_globalvector1,xattend_globalvector2,xattend_globalvector3,xattend_globalvector4,xattend_globalvector5,
							xattend_globalvector6,xattend_globalvector7,xattend_globalvector_mobno,answers2);
					
					attendedlist.setOffsetLeft(xwidth); //left side offset
					attendedlist.setAnimationTime(0);
					attendedlist.setAdapter(declinelistadapter);
		
	}

	protected void greaterimageview() {
		// TODO Auto-generated method stub
		if(open_counter != 0){
		counter++;
		Log.v("counter greaterimageview ", ""+counter);
		Log.v("global_date_arryist.size() ", ""+global_date_arryist.size());
		
		if(counter > global_date_arryist.size()-1){
			counter = global_date_arryist.size()-1;
		}
		
		Log.v("counter greaterimageview222 ", ""+counter);
		Log.v("global_date_arryist greaterimageview ", ""+global_date_arryist.get(counter));
		if(!open_globalvector.isEmpty()){
			open_globalvector.removeAllElements();
		     
		}
		if(!open_globalvector1.isEmpty()){
			open_globalvector1.removeAllElements();
		     
		}
		if(!open_globalvector2.isEmpty()){
			open_globalvector2.removeAllElements();
		     
		}
		if(!open_globalvector3.isEmpty()){
			open_globalvector3.removeAllElements();
		     
		}
		if(!open_globalvector4.isEmpty()){
			open_globalvector4.removeAllElements();
		     
		}
		
		if(!open_globalvector5.isEmpty()){
			open_globalvector5.removeAllElements();
		     
		}
		if(!open_globalvector6.isEmpty()){
			open_globalvector6.removeAllElements();
		     
		}
		if(!open_globalvector7.isEmpty()){
			open_globalvector7.removeAllElements();
		     
		}
		if(!open_globalvector_mobno.isEmpty()){
			open_globalvector_mobno.removeAllElements();
		     
		}
		if(!answers.isEmpty()){
			answers.clear();
		     
		}
		
		greateractionbartv.setText(""+Constants.convertDateformat(""+global_date_arryist.get(counter).trim()));
		
		Log.i("greateractionbartv", ""+Constants.convertDateformat(""+global_date_arryist.get(counter).trim()));

		
		for(int i=0; i<globalvector7.size(); i++){
		    if(globalvector7.elementAt(i).trim().equalsIgnoreCase( ""+global_date_arryist.get(counter).trim()))
		    {               
		    	String idx = Integer.toString(i);
		        //Log.v("globalvector6.elementAt(i)",""+globalvector6.elementAt(i));
		        //Log.v("firstElement ",""+firstElement);
		        int index = Integer.parseInt(idx);
		        //Log.v("index",""+index);
		        String id = ""+globalvector.elementAt(index);
				String name = ""+globalvector1.elementAt(index);
				String no_persons =""+globalvector2.elementAt(index);
				String no_persons2 = ""+globalvector3.elementAt(index);
				String city = ""+globalvector4.elementAt(index);
				String approval = ""+globalvector5.elementAt(index);
				String guest_time = ""+globalvector6.elementAt(index);
				String guest_date = ""+globalvector7.elementAt(index);
				String mobileno = ""+globalvector_mobno.elementAt(index);
				
				if(approval.equalsIgnoreCase("0")){
				   /*Log.v("-----------------------", "---------------------");
				   Log.v("id", ""+id);
				   Log.v("name", ""+name);
				   Log.v("no_persons boys", ""+no_persons);
				   Log.v("no_persons2 girls", ""+no_persons2);
				   Log.v("city", ""+city);
				   Log.v("approval", ""+approval);
				   Log.v("guest_time", ""+guest_time);
				   Log.v("guest_date", ""+guest_date);
				   Log.v("mobileno", ""+mobileno);
				   Log.v("-----------------------", "---------------------");*/
				   
				   open_globalvector.add(id.trim());
				   open_globalvector1.add(name.trim());
				   open_globalvector2.add(no_persons.trim());
				   open_globalvector3.add(no_persons2.trim());
				   open_globalvector4.add(city.trim());
				   open_globalvector5.add(approval.trim());
				   open_globalvector6.add(guest_time.trim());
				   open_globalvector7.add(guest_date.trim());
				   open_globalvector_mobno.add(mobileno.trim());
				   
				   
				}
		    }
		}
		rowItems = new ArrayList<RowItem2>();
		 
		 for (int i = 0; i < open_globalvector.size(); i++) {
			 RowItem2 item = new RowItem2(open_globalvector1.elementAt(i), open_globalvector2.elementAt(i)
	        			        ,open_globalvector3.elementAt(i),open_globalvector4.elementAt(i),open_globalvector.elementAt(i));
	         rowItems.add(item);
	        }
		 
		 listview.setOffsetLeft(xwidth); // left side offset
		 listview.setOffsetRight(xwidth); // right side offset
		 listview.setAnimationTime(0);
		
		 int sizes = open_globalvector.size();
		 
		 for(int i=1; i < sizes+1; i++){
			 answers.add(""+i);
		 }
		
		 CustomguestList adapter = new CustomguestList(getActivity(),R.layout.guest_list, rowItems,open_globalvector,open_globalvector1,open_globalvector2,
				 open_globalvector3,open_globalvector4,open_globalvector5,open_globalvector6,open_globalvector7,open_globalvector_mobno,answers);
		 listview.setAdapter(adapter);
		
		
		}
		//===================================================================================================
		//===================================================================================================
		//===================================================================================================
	   //===================================================================================================
		if(!xapproved_globalvector.isEmpty()){
			xapproved_globalvector.removeAllElements();
		     
		}
		if(!xapproved_globalvector1.isEmpty()){
			xapproved_globalvector1.removeAllElements();
		     
		}
		if(!xapproved_globalvector2.isEmpty()){
			xapproved_globalvector2.removeAllElements();
		     
		}
		if(!xapproved_globalvector3.isEmpty()){
			xapproved_globalvector3.removeAllElements();
		     
		}
		if(!xapproved_globalvector4.isEmpty()){
			xapproved_globalvector4.removeAllElements();
		     
		}
		
		if(!xapproved_globalvector5.isEmpty()){
			xapproved_globalvector5.removeAllElements();
		     
		}
		if(!xapproved_globalvector6.isEmpty()){
			xapproved_globalvector6.removeAllElements();
		     
		}
		if(!xapproved_globalvector7.isEmpty()){
			xapproved_globalvector7.removeAllElements();
		     
		}
		if(!xapproved_globalvector_mobno.isEmpty()){
			xapproved_globalvector_mobno.removeAllElements();
		}
		if(!answers1.isEmpty()){
			answers1.clear();
		}
		
		for(int i=0; i<approved_globalvector7.size(); i++){
		    if(approved_globalvector7.elementAt(i).trim().equalsIgnoreCase( ""+global_date_arryist.get(counter).trim()))
		    {               
		    	String idx = Integer.toString(i);
		        //Log.v("globalvector6.elementAt(i)",""+globalvector6.elementAt(i));
		        //Log.v("firstElement ",""+firstElement);
		        int index = Integer.parseInt(idx);
		        //Log.v("index",""+index);
		        String id = ""+approved_globalvector.elementAt(index);
				String name = ""+approved_globalvector1.elementAt(index);
				String no_persons =""+approved_globalvector2.elementAt(index);
				String no_persons2 = ""+approved_globalvector3.elementAt(index);
				String city = ""+approved_globalvector4.elementAt(index);
				String approval = ""+approved_globalvector5.elementAt(index);
				String guest_time = ""+approved_globalvector6.elementAt(index);
				String guest_date = ""+approved_globalvector7.elementAt(index);
				String mobileno = ""+approved_globalvector_mobno.elementAt(index);
				
				if(approval.equalsIgnoreCase("1")){
				  /* Log.v("-----------------------", "---------------------");
				   Log.v("id", ""+id);
				   Log.v("name", ""+name);
				   Log.v("no_persons boys", ""+no_persons);
				   Log.v("no_persons2 girls", ""+no_persons2);
				   Log.v("city", ""+city);
				   Log.v("approval", ""+approval);
				   Log.v("guest_time", ""+guest_time);
				   Log.v("guest_date", ""+guest_date);
				   Log.v("mobileno", ""+mobileno);
				   Log.v("-----------------------", "---------------------");*/
				   
					xapproved_globalvector.add(id.trim());
					xapproved_globalvector1.add(name.trim());
					xapproved_globalvector2.add(no_persons.trim());
					xapproved_globalvector3.add(no_persons2.trim());
					xapproved_globalvector4.add(city.trim());
					xapproved_globalvector5.add(approval.trim());
					xapproved_globalvector6.add(guest_time.trim());
					xapproved_globalvector7.add(guest_date.trim());
					xapproved_globalvector_mobno.add(mobileno.trim());
				   
				}
		    }
		}
		    rowItems3 = new ArrayList<RowItem3>();
			for (int i1 = 0; i1 < xapproved_globalvector.size(); i1++) {
				//Log.i("all data", ""+GlobalValues.globalvector.elementAt(i));
				RowItem3 item3 = new RowItem3(xapproved_globalvector.elementAt(i1), xapproved_globalvector1.elementAt(i1)
			        ,xapproved_globalvector2.elementAt(i1),xapproved_globalvector3.elementAt(i1),xapproved_globalvector4.elementAt(i1));

				rowItems3.add(item3);
			}
				int sizes2 = xapproved_globalvector.size();
				
				 for(int i1=1; i1 < sizes2+1; i1++){
					 answers1.add(""+i1);
				 }
					
				CustomApproveList aprrovelist = new CustomApproveList(getActivity(),R.layout.approve_list,rowItems3,xapproved_globalvector,
						xapproved_globalvector1,xapproved_globalvector2,xapproved_globalvector3,xapproved_globalvector4,
						xapproved_globalvector5,xapproved_globalvector6,xapproved_globalvector7,xapproved_globalvector_mobno,answers1);
				
				approvelistview.setOffsetLeft(xwidth); // left side offset
				approvelistview.setAnimationTime(0);
				approvelistview.setAdapter(aprrovelist); 
				
				
				//===================================================================================================
				//===================================================================================================
				//===================================================================================================
			   //===================================================================================================	
				if(!xattend_globalvector.isEmpty()){
					xattend_globalvector.removeAllElements();
				     
				}
				if(!xattend_globalvector1.isEmpty()){
					xattend_globalvector1.removeAllElements();
				     
				}
				if(!xattend_globalvector2.isEmpty()){
					xattend_globalvector2.removeAllElements();
				     
				}
				if(!xattend_globalvector3.isEmpty()){
					xattend_globalvector3.removeAllElements();
				     
				}
				if(!xattend_globalvector4.isEmpty()){
					xattend_globalvector4.removeAllElements();
				     
				}
				
				if(!xattend_globalvector5.isEmpty()){
					xattend_globalvector5.removeAllElements();
				     
				}
				if(!xattend_globalvector6.isEmpty()){
					xattend_globalvector6.removeAllElements();
				     
				}
				if(!xattend_globalvector7.isEmpty()){
					xattend_globalvector7.removeAllElements();
				     
				}
				if(!xattend_globalvector_mobno.isEmpty()){
					xattend_globalvector_mobno.removeAllElements();
				}
				if(!answers2.isEmpty()){
					answers2.clear();
				}
				
				for(int i=0; i<attend_globalvector7.size(); i++){
				    if(attend_globalvector7.elementAt(i).trim().equalsIgnoreCase( ""+global_date_arryist.get(counter).trim()))
				    {               
				    	String idx = Integer.toString(i);
				        //Log.v("globalvector6.elementAt(i)",""+globalvector6.elementAt(i));
				        //Log.v("firstElement ",""+firstElement);
				        int index = Integer.parseInt(idx);
				        //Log.v("index",""+index);
				        String id = ""+attend_globalvector.elementAt(index);
						String name = ""+attend_globalvector1.elementAt(index);
						String no_persons =""+attend_globalvector2.elementAt(index);
						String no_persons2 = ""+attend_globalvector3.elementAt(index);
						String city = ""+attend_globalvector4.elementAt(index);
						String approval = ""+attend_globalvector5.elementAt(index);
						String guest_time = ""+attend_globalvector6.elementAt(index);
						String guest_date = ""+attend_globalvector7.elementAt(index);
						String mobileno = ""+attend_globalvector_mobno.elementAt(index);
						
						  /* Log.v("-----------------------", "---------------------");
						   Log.v("id", ""+id);
						   Log.v("name", ""+name);
						   Log.v("no_persons boys", ""+no_persons);
						   Log.v("no_persons2 girls", ""+no_persons2);
						   Log.v("city", ""+city);
						   Log.v("approval", ""+approval);
						   Log.v("guest_time", ""+guest_time);
						   Log.v("guest_date", ""+guest_date);
						   Log.v("mobileno", ""+mobileno);
						   Log.v("-----------------------", "---------------------");*/
						   
							xattend_globalvector.add(id.trim());
							xattend_globalvector1.add(name.trim());
							xattend_globalvector2.add(no_persons.trim());
							xattend_globalvector3.add(no_persons2.trim());
							xattend_globalvector4.add(city.trim());
							xattend_globalvector5.add(approval.trim());
							xattend_globalvector6.add(guest_time.trim());
							xattend_globalvector7.add(guest_date.trim());
							xattend_globalvector_mobno.add(mobileno.trim());
						
				    }
				}	
				rowItems4 = new ArrayList<RowItem4>();
				
				for (int i = 0; i < xattend_globalvector.size(); i++) {
					RowItem4 item4 = new RowItem4(xattend_globalvector.elementAt(i), xattend_globalvector1.elementAt(i)
        			        ,xattend_globalvector2.elementAt(i),xattend_globalvector3.elementAt(i),xattend_globalvector4.elementAt(i));
					rowItems4.add(item4);
				}
				
					int sizes3 = xattend_globalvector.size();
					 
					 for(int i1=1; i1 < sizes3+1; i1++){
						 answers2.add(""+i1);
					 }
					
					CustomDeclinelist declinelistadapter = new CustomDeclinelist(getActivity(),R.layout.decline_list,rowItems4,xattend_globalvector
							,xattend_globalvector1,xattend_globalvector2,xattend_globalvector3,xattend_globalvector4,xattend_globalvector5,
							xattend_globalvector6,xattend_globalvector7,xattend_globalvector_mobno,answers2);
					
					attendedlist.setOffsetLeft(xwidth); //left side offset
					attendedlist.setAnimationTime(0);
					attendedlist.setAdapter(declinelistadapter);
				
		
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.v("onActivityResult", "onActivityResult");
		if (requestCode == 3) {
			//Log.v("requestCode == 3", ""+resultCode);
			
			if(resultCode == Activity.RESULT_OK){
	            String result=data.getStringExtra("result");
	        	Log.v("result", result);
	        	new ImageDownloader2().execute();
	        }
	    }
	}
}
