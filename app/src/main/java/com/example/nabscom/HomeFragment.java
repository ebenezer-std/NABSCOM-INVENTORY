package com.example.nabscom;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView productRecycler;
    private ProductAdapter myProductAdapter;
    private DatabaseReference mDatabase;
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private FirebaseDatabase mFirebaseInstance;
    private List<Product> mProductList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        productRecycler = view.findViewById(R.id.recycler);
//        viewPager = view.findViewById(R.id.viewPager);
//        tabLayout = view.findViewById(R.id.tabLayout);
//        adapter = new TabAdapter(getFragmentManager());
//        adapter.addFragment(new CategoryFragment(), "PizzaIn");
//        adapter.addFragment(new HomeFragment(), "Accessories");
////        adapter.addFragment(new Tab3Fragment(), "Tab 3");
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);

        initView();
        return view;

    }

    private void initView() {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabase = mFirebaseInstance.getReference("accessories");


//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        productRecycler.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(productRecycler.getContext(),
                layoutManager.getOrientation());
        productRecycler.addItemDecoration(dividerItemDecoration);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mProductList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Product product = dataSnapshot1.getValue(Product.class);
                    mProductList.add(product);
                }
                myProductAdapter = new ProductAdapter(getContext(), mProductList);
                productRecycler.setAdapter(myProductAdapter);
                myProductAdapter.notifyDataSetChanged();

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}