package com.kaka.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaka.dialogdemo.utils.DialogHelper;
import com.kaka.dialogdemo.utils.DialogType;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MyDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyDialogFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private DialogType dialogType;

    public MyDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment DialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyDialogFragment newInstance(DialogType param1) {
        MyDialogFragment fragment = new MyDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dialogType = (DialogType) getArguments().get(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_edit_name, container);
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog alertDialog=DialogHelper.getInstance(getActivity()).createDialogFragmentView();
        switch (dialogType){
            case CUSTOMVIEW:
                alertDialog =DialogHelper.getInstance(getActivity()).createDialogFragmentView();
                break;
            case ITEMS:
                alertDialog =DialogHelper.getInstance(getActivity()).createItemDialog();
                break;
            case SINGLECHOICE:
                alertDialog =DialogHelper.getInstance(getActivity()).createSingleChoiceDialog();
                break;
            case MULTICHOICE:
                alertDialog =DialogHelper.getInstance(getActivity()).createMultiChoiceDialog();
                break;
            case LISTADAPTER:
                alertDialog =DialogHelper.getInstance(getActivity()).createListAdapterDialog();
                break;
            default:
                break;
        }
        return alertDialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
