private var noteComments = mutableListOf<Comments>()

class ServiceComments : ServiceInterface<Comments>{

    override fun add(element: Comments): Int {
        val newId = if (noteComments.isNotEmpty()) noteComments.last().commentId + 1 else 1
        val nextComment = element.copy(commentId = newId)
        noteComments.add(nextComment)
        return noteComments.last().commentId
    }

    override fun delete(id:Int): Boolean {
        var result = false
        var indexOf = 0
        for ((index, value) in noteComments.withIndex()) {
            if (id == value.commentId && !value.deleted) {
                result = true
            }
        }
        if (result) {
            noteComments[indexOf].deleted = true
        } else throw CommentNotFoundException()
        return result
    }

    override fun edit(element: Comments): Boolean {
        var result = false
        if (noteComments.contains(element) && !element.deleted) {
            val editComments = element.copy(commentId = element.commentId)
            noteComments.set(element.commentId,editComments)
            result = true
        } else {
            throw CommentNotFoundException()
            result = false
        }
        return result

//        return if (noteComments.contains(element) && !element.deleted) {
//            val editComments = element.copy(commentId = element.commentId)
//            noteComments.set(element.commentId,editComments)
//            true
//        } else
//            false
    }

    override fun get(): List<Comments> {
        var result = false
        for ((index, value) in noteComments.withIndex()) {
            if (value.deleted) {
                result = true
            }
        }
        if(result == false){
            return noteComments
        } else throw CommentNotFoundException()
    }


    fun restoreComment(id:Int):Boolean {
        var result = false
        for ((index, value) in noteComments.withIndex()) {
            if (id == value.commentId && value.deleted) {
                result = true
            } else {
                throw CommentNotFoundException()
            }
        }
        return result



    }
}