import java.lang.Exception

private var notesArray = mutableListOf<Notes>()

class ServiceNotes: ServiceInterface<Notes> {

    override fun add(element: Notes): Int {
        val newId = if (notesArray.isNotEmpty()) notesArray.last().noteId + 1 else 1
        val nextNote = element.copy(noteId = newId)
        notesArray.add(nextNote)
        return notesArray.last().noteId
    }

    override fun delete(id:Int): Boolean {
        var result = false
        var indexOf = 0
        for ((index, value) in notesArray.withIndex()) {
            if (id == value.noteId) {
                result = true
                indexOf = notesArray.indexOf(value)
            }
        }
        if (result){
            notesArray.removeAt(indexOf)
        } else{
            throw NoteNotFoundException()
        }
        return result
    }

    override fun edit(element: Notes): Boolean {
        var result = false
        if (notesArray.contains(element)) {
            val editNotes = element.copy(noteId = element.noteId)
            notesArray.set(element.noteId,editNotes)
            result = true
        } else {
            throw NoteNotFoundException()
        }
        return result
    }

    override fun get(): List<Notes> {
        if (notesArray.isEmpty()){
            throw ListIsEmptyException()
        }
        return notesArray
    }

    fun getById(id : Int) : Notes{
        val listByID = mutableListOf<Notes>()
        for (notes in notesArray) {
            if (id == notes.noteId)
                listByID.add(notes)
        }
        return if (listByID.isNotEmpty()) listByID.last() else throw NoteNotFoundException()
    }

}