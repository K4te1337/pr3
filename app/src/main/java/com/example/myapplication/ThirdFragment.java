package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentThirdBinding binding = FragmentThirdBinding.inflate(inflater, container,
                false);
        binding.button.setOnClickListener(view -> {
            Bundle result = new Bundle();
            result.putString("bundleKey", "Данные от другого фрагмента");
            getParentFragmentManager().setFragmentResult(
                    "requestKey", result);
        });
        return binding.getRoot();
    }
}