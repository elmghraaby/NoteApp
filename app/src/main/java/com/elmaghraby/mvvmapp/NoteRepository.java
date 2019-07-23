package com.elmaghraby.mvvmapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstace(application);
        noteDao = database.noteDao();

        allNotes = noteDao.getAllNotes();
    }


    public void insert(Note note) {
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    public void updata(Note note) {
        new updateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new deleteNoteAsyncTask(noteDao).execute(note);
    }
    public void deleteAllNotes(){
        new deleteAllNotesAsyncTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void>{

        private NoteDao noteDao;
        private InsertNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    private static class updateNoteAsyncTask extends AsyncTask<Note, Void, Void>{

        private NoteDao noteDao;
        private updateNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }
    private static class deleteNoteAsyncTask extends AsyncTask<Note, Void, Void>{

        private NoteDao noteDao;
        private deleteNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
    private static class deleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void>{

        private NoteDao noteDao;
        private deleteAllNotesAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... Voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }
}
