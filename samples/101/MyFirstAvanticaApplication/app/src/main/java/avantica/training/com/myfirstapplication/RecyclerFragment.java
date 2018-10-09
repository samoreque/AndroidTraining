package avantica.training.com.myfirstapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecyclerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootView;
    private RecyclerView rvPersons;


    private OnFragmentInteractionListener mListener;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfromationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.fragment_recycler, container, false);
        rvPersons = rootView.findViewById(R.id.rvPersons);
        rvPersons.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvPersons.setLayoutManager(manager);
        rvPersons.setAdapter(new MyAdapter(getAllPeople()));
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            /*throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");*/
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public List<Person> getAllPeople() {
        List<Person> peopleList = new ArrayList<>();
        peopleList.add(new Person("Samuel", android.R.drawable.ic_media_next));
        peopleList.add(new Person("Wilder", android.R.drawable.ic_dialog_email));
        peopleList.add(new Person("Diego", android.R.drawable.ic_lock_power_off));
        peopleList.add(new Person("Bryan", android.R.drawable.ic_delete));
        peopleList.add(new Person("Wilson", android.R.drawable.ic_dialog_info));
        peopleList.add(new Person("Samuel", android.R.drawable.ic_media_next));
        peopleList.add(new Person("Wilder", android.R.drawable.ic_dialog_email));
        peopleList.add(new Person("Diego", android.R.drawable.ic_lock_power_off));
        peopleList.add(new Person("Bryan", android.R.drawable.ic_delete));
        peopleList.add(new Person("Wilson", android.R.drawable.ic_dialog_info));
        peopleList.add(new Person("Samuel", android.R.drawable.ic_media_next));
        peopleList.add(new Person("Wilder", android.R.drawable.ic_dialog_email));
        peopleList.add(new Person("Diego", android.R.drawable.ic_lock_power_off));
        peopleList.add(new Person("Bryan", android.R.drawable.ic_delete));
        peopleList.add(new Person("Wilson", android.R.drawable.ic_dialog_info));
        peopleList.add(new Person("Samuel", android.R.drawable.ic_media_next));
        peopleList.add(new Person("Wilder", android.R.drawable.ic_dialog_email));
        peopleList.add(new Person("Diego", android.R.drawable.ic_lock_power_off));
        peopleList.add(new Person("Bryan", android.R.drawable.ic_delete));
        peopleList.add(new Person("Wilson", android.R.drawable.ic_dialog_info));
        return peopleList;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private List<Person> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView txtName;
            public ImageView imgPhoto;
            public int position = -1;
            public MyViewHolder(View v) {
                super(v);
                txtName = v.findViewById(R.id.txtName);
                imgPhoto = v.findViewById(R.id.imgPhoto);
            }

            public void bind(final Person person, int position) {
                txtName.setText(person.Name);
                imgPhoto.setImageResource(person.photoResId);
                this.position = position;
                imgPhoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "click on " + person.Name, Toast.LENGTH_SHORT).show();
                    }
                });
                if (!person.Name.toLowerCase().contains("samuel")){
                    imgPhoto.setVisibility(View.INVISIBLE);
                } else {
                    imgPhoto.setVisibility(View.VISIBLE);
                }
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(List<Person> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            View v =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_persons_item, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            Log.d(MyAdapter.class.getName(), "holder changed from " + holder.position + " to " + position);
            holder.bind(mDataset.get(position), position);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
}
