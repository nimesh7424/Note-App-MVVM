package com.nimesh.note.domain.usecase

data class NotesUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCase: AddNotesUseCase,
    val getNoteUseCase: GetNoteUseCase
)
