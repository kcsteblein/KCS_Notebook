package com.kcsteblein.notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kenneth on 8/8/2016.
 */
public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, ArrayList<Note> notes){
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get data item for position
        Note note = getItem(position);

        //check if existing view is being reused, otherwise inflate a anew view from custom row layout
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        }

        //grab references of views so we can populate them with specific note row data
        TextView noteTitle = (TextView) convertView.findViewById(R.id.listItemNoteTitle);
        TextView noteText = (TextView) convertView.findViewById(R.id.listItemNoteBody);
        ImageView noteIcon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

        //fill each new referenced view with data associated with note it's referencing
        noteTitle.setText(note.getTitle());
        noteText.setText(note.getMessage());
        noteIcon.setImageResource(note.getAssociatedDrawable());

        //now that we modified the view to display appropriate data, return it so it will be displayed
        return convertView;
    }

}
