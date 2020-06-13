package com.tryoasnafi.myflexiblefragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CategoryFragment extends Fragment implements View.OnClickListener{

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_detail_category) {
            DetailCategoryFragment detailCategoryFragment = new DetailCategoryFragment();

            // Mengirim data dengan bundle
            Bundle mBundle = new Bundle();
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
            // Mengirim data dengan setter getter
            String description = "Kategori ini akan berisi produk-produk lifestyle";

            detailCategoryFragment.setArguments(mBundle);
            detailCategoryFragment.setDescription(description);

            /**
            * Method addToBackStack akan menambahkan fragment ke backstack
            * Behaviour dari back button akan cek fragment dari backstack,
            * jika ada fragment di dalam backstack maka fragment yang akan di close / remove
            * jika sudah tidak ada fragment di dalam backstack maka activity yang akan di close / finish
             */
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment.class.getSimpleName())
                        .addToBackStack(null) // Ketika tombol back di tekan maka kembali ke stack tidak pop out keluar (tertutup)
                        .commit();
            }
        }
    }
}