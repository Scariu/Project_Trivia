package com.example.project_trivia;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_trivia.databinding.FragmentSecondBinding;
import com.example.project_trivia.databinding.FragmentThirdBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private boolean resultCorrect = false;
    private Drawable imageCongrats;
    private Drawable imageSad;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("nombre");
            mParam2 = getArguments().getString(ARG_PARAM2);
            resultCorrect = getArguments().getBoolean("respuesta");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(getLayoutInflater(), container, false);
        imageSad = getResources().getDrawable(R.drawable.sad);
        imageCongrats = getResources().getDrawable(R.drawable.congrats);
        if(resultCorrect == true){
            binding.textViewRespuesta.setText("Muy bien "+ mParam1 + " ¡Has contestado correctamente!");
            binding.imageViewRespuesta.setImageDrawable(imageCongrats);
        } else  {
            binding.textViewRespuesta.setText("Te equivocaste " + mParam1 + " ¡Intentalo denuevo!");
            binding.imageViewRespuesta.setImageDrawable(imageSad);
        }
        binding.buttonReintentar.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("nombre", mParam1);
            Navigation.findNavController(getView()).navigate(R.id.action_thirdFragment_to_secondFragment,bundle);
        });
        return binding.getRoot();
    }

}