//package com.example.hoang.myapplication.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.hoang.myapplication.R;
//import com.example.hoang.myapplication.helper.Helper;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import de.hdodenhof.circleimageview.CircleImageView;
//
//
///**
// * Created by hoang on 11/23/16.
// */
//
//public class FragmentProfile extends Fragment {
//
//    FragmentManager fragmentManager;
//    @BindView(R.id.ivAvatar)
//    CircleImageView ivAvatar;
//    View view;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_profile_layout, container, false);
//
//        ButterKnife.bind(this, view);
//
//        avatarClick();
//
//        return view;
//    }
//
//    private void avatarClick() {
//        ivAvatar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Helper.showMsg(getContext(),"Huu");
//                ShowDialogAvatar();
//            }
//        });
//    }
//
//    private void ShowDialogAvatar() {
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        Frag_ava = new F
////        final Dialog dlAvatar = new Dialog(getContext());
////        dlAvatar.setTitle("titiel");
////        dlAvatar.setContentView(R.layout.dialog_avatar_layout);
////        TextView tvChangeAvatar = (TextView) dlAvatar.findViewById(R.id.tvChangeAvatar);
////        tvChangeAvatar.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Helper.showMsg(getContext(), "btn1");
////                getContext().startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
////            }
////        });
////
////        TextView tvViewAvatar = (TextView) dlAvatar.findViewById(R.id.tvViewAvatar);
////        tvViewAvatar.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Helper.showMsg(getContext(), "Show avatar Action");
////            }
////        });
////        dlAvatar.show();
//
//
//
//
//    }
//
//}
//
