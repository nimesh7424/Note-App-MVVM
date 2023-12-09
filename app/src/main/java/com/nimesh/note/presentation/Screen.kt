package com.nimesh.note.presentation

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("edit_note_screen")
}
