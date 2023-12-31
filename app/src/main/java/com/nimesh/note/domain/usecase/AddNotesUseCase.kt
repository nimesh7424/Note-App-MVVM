package com.nimesh.note.domain.usecase

import com.nimesh.note.domain.model.InvalidNoteException
import com.nimesh.note.domain.model.Note
import com.nimesh.note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNotesUseCase(
    private val noteRepository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        noteRepository.insertNote(note)
    }
}