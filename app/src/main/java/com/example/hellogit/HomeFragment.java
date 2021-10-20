package com.example.hellogit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /*String positif = "";
    String sembuh = "";
    String meninggal = "";
    String rawat = "";*/

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        String URL = "https://api.kawalcorona.com/indonesia/";

        /*
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        TextView Total_positif = (TextView)findViewById(R.id.Total_Kasus_NumberPlaceholder);
        TextView Total_sembuh = (TextView)findViewById(R.id.homepage_isi_negatif);
        TextView Total_meninggal = (TextView)findViewById(R.id.homepage_isi_meninggal);
        TextView Total_rawat = (TextView)findViewById(R.id.homepage_isi_rawat);


        StringRequest objectRequest = new StringRequest (
                Request.Method.GET,
                URL,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONArray jsonarray = new JSONArray(response);

                            for(int i = 0; i < jsonarray.length(); i++){
                                JSONObject jsonobject = jsonarray.getJSONObject(i);
                                positif = jsonobject.getString("positif");
                                sembuh = jsonobject.getString("sembuh");
                                meninggal = jsonobject.getString("meninggal");
                                rawat = jsonobject.getString("dirawat");
                                Log.e("response 1", jsonobject.toString());
                                Log.e("response 2", positif);

                                Total_positif.setText(positif);
                                Total_sembuh.setText(sembuh);
                                Total_meninggal.setText(meninggal);
                                Total_rawat.setText(rawat);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.e("rest response", error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}