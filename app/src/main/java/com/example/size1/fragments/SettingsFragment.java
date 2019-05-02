package com.example.a1size.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a1size.R;
import com.example.a1size.Settings.EProfileActivity;
import com.example.a1size.Settings.PreferenceActivity;
import com.example.a1size.Settings.PrivacyPolicyActivity;
import com.example.a1size.Settings.SocialMediaActivity;
import com.example.a1size.Settings.TermServicesActivity;

public class SettingsFragment extends Fragment {
    private final String TAG = "SettingsFragment";
    private Button eProfile;
    private Button smConnect;
    private Button preference;
    private Button pPolicy;
    private Button tOfService;
    private Button logOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eProfile =  view.findViewById(R.id.eProfile);
        eProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditProfile();
            }
        });
        smConnect =  view.findViewById(R.id.smConnect);
        smConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SocialMedia();
            }
        });
        preference=  view.findViewById(R.id.preference);
        preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences();
            }
        });
        pPolicy =  view.findViewById(R.id.pPolicy);
        pPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Policy();
            }
        });
        tOfService=  view.findViewById(R.id.tOfService);
        tOfService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services();
            }
        });
        logOut =  view.findViewById(R.id.logOut);


    }

    private void Services() {

        Intent intent = new Intent(this.getActivity(), TermServicesActivity.class);
        startActivity(intent);
    }

    private void Policy() {
        Intent intent = new Intent(this.getActivity(), PrivacyPolicyActivity.class);
        startActivity(intent);
    }

    private void Preferences() {

        Intent intent = new Intent(this.getActivity(), PreferenceActivity.class);
        startActivity(intent);
    }

    private void SocialMedia() {

        Intent intent = new Intent(this.getActivity(), SocialMediaActivity.class);
        startActivity(intent);
    }

    private void EditProfile() {

        Intent intent = new Intent(this.getActivity(), EProfileActivity.class);
        startActivity(intent);
    }


}