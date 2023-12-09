package com.nimesh.note.domain.usecase

import com.nimesh.note.domain.model.Note
import com.nimesh.note.domain.repository.NoteRepository

class GetNoteUseCase(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return noteRepository.getNoteById(id)
    }
}