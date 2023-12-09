package com.nimesh.note.domain.usecase

import com.nimesh.note.domain.model.Note
import com.nimesh.note.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note) = noteRepository.deleteNote(note)
}