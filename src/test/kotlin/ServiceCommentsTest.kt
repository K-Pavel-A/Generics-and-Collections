import org.junit.Test

import org.junit.Assert.*

class ServiceCommentsTest {

    val serviceTestComments = ServiceComments()

    @Test
    fun add_EmptyList() {
        val comment1 = Comments("",1,1,false)

        val result = serviceTestComments.add(comment1)
        val expected = 1

        assertEquals(expected,result)
    }

    @Test
    fun add_NotEmptyList() {
        val comment1 = Comments("",1,1,false)
        val comment2 = Comments("",1,2,false)
        val comment3 = Comments("",1,3,false)

        serviceTestComments.add(comment1)
        serviceTestComments.add(comment2)

        val result = serviceTestComments.add(comment3)
        val expected = 3

        assertEquals(expected, result)
    }

    @Test
    fun delete_ExistComment_NotDelete() {
        val comment1 = Comments("",1,1,false)
        val comment2 = Comments("",1,2,false)

        serviceTestComments.add(comment1)
        serviceTestComments.add(comment2)
        val result = serviceTestComments.delete(1)

        assertTrue(result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun delete_NotExistComment() {
        val comment1 = Comments("",1,1,false)
        val comment2 = Comments("",1,2,false)

        serviceTestComments.add(comment1)
        serviceTestComments.add(comment2)
        serviceTestComments.delete(5)
    }

    @Test(expected = CommentNotFoundException::class)
    fun delete_NotExistComment_Deleted() {
        val comment1 = Comments("",1,1,true)
        val comment2 = Comments("",1,2,false)

        serviceTestComments.add(comment1)
        serviceTestComments.add(comment2)
        serviceTestComments.delete(1)
    }

    @Test
    fun edit_ExistComment() {
        val comment1 = Comments("",1,1,false)
        val comment2 = Comments("",1,2,false)

        serviceTestComments.add(comment1)
        serviceTestComments.add(comment2)

        val result = serviceTestComments.edit(comment1)

        assertTrue(result)
    }
    @Test(expected = CommentNotFoundException::class)
    fun edit_NotExistComment() {
        val comment1 = Comments("",1,1,false)
        val comment2 = Comments("",1,2,false)
        val comment3 = Comments("",1,3,false)

        serviceTestComments.add(comment1)
        serviceTestComments.add(comment2)

        serviceTestComments.edit(comment3)
    }

    @Test(expected = CommentNotFoundException::class)
    fun edit_DeletedComment() {
        val comment1 = Comments("",1,1,false)
        val comment2 = Comments("",1,2,false)

        serviceTestComments.add(comment1)
        serviceTestComments.add(comment2)
        serviceTestComments.delete(1)

        serviceTestComments.edit(comment1)
    }

    @Test
    fun restoreComment() {
        val comment1 = Comments("",1,1,false)
        val comment2 = Comments("",1,2,false)

        serviceTestComments.add(comment1)
        serviceTestComments.add(comment2)
        serviceTestComments.delete(1)

        val result = serviceTestComments.restoreComment(1)
        assertTrue(result)
    }
}