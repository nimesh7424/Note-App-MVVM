package com.nimesh.note.presentation.notes

import com.nimesh.note.domain.model.Note
import com.nimesh.note.domain.util.NoteOrder
import com.nimesh.note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
