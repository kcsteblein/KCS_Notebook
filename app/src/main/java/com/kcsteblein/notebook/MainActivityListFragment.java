package com.kcsteblein.notebook;


import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.print.PrintHelper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        /*
        String[] values = new String[]{ "Android", "iPhone", "WindowsMobile",
                "BlackBerry"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);
        */

        notes = new ArrayList<Note>();

        notes.add(new Note("This is a new note title!", "This is the body of our note!",
                Note.Category.PERSONAL));

        noteAdapter = new NoteAdapter(getActivity(), notes);

        setListAdapter(noteAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
    }


}
