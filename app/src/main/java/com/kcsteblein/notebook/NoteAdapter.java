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

    public static class ViewHolder{
        TextView title;
        TextView note;
        ImageView icon;
    }

    public NoteAdapter(Context context, ArrayList<Note> notes){
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get data item for position
        Note note = getItem(position);

        //create a new viewholder
        ViewHolder viewHolder;


        //check if existing view is being reused, otherwise inflate a anew view from custom row layout
        if (convertView == null) {

            //if we don't have a view that is being used create one,
            //and make sure you create a view holder along with it to save our data references
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

            //grab references of views so we can populate them with specific note row data
            viewHolder.title = (TextView) convertView.findViewById(R.id.listItemNoteTitle);
            viewHolder.note = (TextView) convertView.findViewById(R.id.listItemNoteBody);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

            //use set tag to remember our view holder which is holding references to our widgets
            convertView.setTag(viewHolder);
        }else{
            //we already have a view so go to our viewholder and grab the widgets from it
            viewHolder = (ViewHolder) convertView.getTag();
        }


        //fill each new referenced view with data associated with note it's referencing
        viewHolder.title.setText(note.getTitle());
        viewHolder.note.setText(note.getMessage());
        viewHolder.icon.setImageResource(note.getAssociatedDrawable());

        //now that we modified the view to display appropriate data, return it so it will be displayed
        return convertView;
    }

}
