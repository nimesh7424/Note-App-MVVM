package com.nimesh.note.di

import android.app.Application
import androidx.room.Room
import com.nimesh.note.data.data_source.NoteDatabase
import com.nimesh.note.data.repository.NoteRepositoryImpl
import com.nimesh.note.domain.repository.NoteRepository
import com.nimesh.note.domain.usecase.AddNotesUseCase
import com.nimesh.note.domain.usecase.DeleteNoteUseCase
import com.nimesh.note.domain.usecase.GetNoteUseCase
import com.nimesh.note.domain.usecase.GetNotesUseCase
import com.nimesh.note.domain.usecase.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABSE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }


    @Provides
    @Singleton
    fun providesNotesUseCase(noteRepository: NoteRepository) : NotesUseCases {
        return NotesUseCases(
            getNotesUseCase = GetNotesUseCase(noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(noteRepository),
            addNoteUseCase = AddNotesUseCase(noteRepository),
            getNoteUseCase = GetNoteUseCase(noteRepository)
        )
    }

}