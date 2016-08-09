package com.kcsteblein.notebook;

/**
 * Created by Kenneth on 8/8/2016.
 */
public class Note {
    private String title, message;
    private long noteID, dayCreatedMilli;
    private Category category;

    public enum Category{ PERSONAL, TECHNICAL, QOUTE, FINANCE}

    public Note( String title, String message, Category category){
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteID = 0;
        this.dayCreatedMilli = 0;
    }

    public Note(String title, String message, Category category, long noteID, long dayCreatedMilli){
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteID = noteID;
        this.dayCreatedMilli = dayCreatedMilli;
    }

    public String getTitle(){
        return title;
    }

    public String getMessage(){
        return message;
    }

    public Category getCategory(){
        return category;
    }

    public long getDate(){
        return dayCreatedMilli;
    }

    public long getNoteID(){
        return noteID;
    }

    public String toString(){
        return "ID: " + noteID + " Title: " + title + " Message: " + message + " IconID: " + category.name() + " Date: ";
    }

    public int getAssociatedDrawable(){
        return categoryToDrawable(category);
    }

    public static int categoryToDrawable(Category noteCategory){
        switch (noteCategory) {
            case PERSONAL:
                return R.drawable.p;
            case TECHNICAL:
                return R.drawable.t;
            case FINANCE:
                return R.drawable.f;
            case QOUTE:
                return R.drawable.q;
        }

        return R.drawable.p;
    }
}
