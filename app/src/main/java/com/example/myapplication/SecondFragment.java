package com.example.myapplication;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.databinding.FragmentSecondBinding;
public class SecondFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(
                            R.id.fragment_container,
                            ThirdFragment.class,
                            null
                    )
                    .commit();
            getChildFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(
                            R.id.fragment_container_2,
                            FourFragment.class,
                            null
                    )
                    .commit();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSecondBinding binding = FragmentSecondBinding.inflate(inflater, container, false);
        getChildFragmentManager()
                .setFragmentResultListener("requestKey", this, ((requestKey, result) -> {
                    binding.textView.setText(result.getString("bundleKey"));
                }));
        return binding.getRoot();
    }
}