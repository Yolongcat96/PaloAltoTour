package com.example.android.paloaltotour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TransportationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TransportationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransportationFragment extends Fragment {

    final String categoryName = "Transportations";

    public TransportationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        // Create a list of place items
        final ArrayList<listItemUnit> items = new ArrayList<listItemUnit>();
        // pick up the place item from the itemUnitCollection
        int sizeCollection = itemUnitCollection.getInstance().itemList.size();
        int count = 0;
        for (int i = 0; i < sizeCollection; i++) {
            listItemUnit _tempUnit = itemUnitCollection.getInstance().itemList.get(i);
            if (_tempUnit.getCategoryName().compareTo(categoryName) == 0) {
                _tempUnit.setmImageResourceId(itemUnitCollection.getInstance().transportationImages[count]);
                items.add(_tempUnit);
                count++;
            }
        }
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        listItemUnitAdapter adapter = new listItemUnitAdapter(getActivity(), items, R.color.category_main_trasportations);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                listItemUnit item = items.get(position);
                // call the item detail view based on the clicked information
                Intent itemDetailedViewIntent = new Intent(getContext(), itemDetailView.class);
                itemDetailedViewIntent.putExtra("itemName", item.getItemName());
                startActivity(itemDetailedViewIntent);
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
    }
}
