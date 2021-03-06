package com.example.englishcard.ui.fragments.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.englishcard.databinding.FragmentCategotyBottomSheetBinding;
import com.example.englishcard.models.db_models.CategoryModel;
import com.example.englishcard.viewmodel.PixaBayViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CategoryBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentCategotyBottomSheetBinding binding;
    PixaBayViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategotyBottomSheetBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        viewModel = new ViewModelProvider(this).get(PixaBayViewModel.class);
    }


    private void initListeners() {
        binding.btnCreate.setOnClickListener( view -> {
            String category = binding.etCategory.getText().toString();
            CategoryModel categoryModel = new CategoryModel(category);
            viewModel.insertCategory(categoryModel);
        } );
    }
}