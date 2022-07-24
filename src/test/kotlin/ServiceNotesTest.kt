import org.junit.Test

import org.junit.Assert.*

class ServiceNotesTest {
    val serviceTest = ServiceNotes()

    @Test
    fun add_EmptyList() {
        val note1 = Notes("1","",1, 1, "", "",1, 1, "", 1)

        val result = serviceTest.add(note1)
        val expected = 1

        assertEquals(expected,result)
    }

    @Test
    fun add_NotEmptyList() {
        val note1 = Notes("1","",1, 1, "", "",1, 1, "", 1)
        val note2 = Notes("2","",1, 1, "", "",2, 1, "", 1)
        val note3 = Notes("3","",1, 1, "", "",3, 1, "", 1)

        serviceTest.add(note1)
        serviceTest.add(note2)
        val result = serviceTest.add(note3)
        val expected = 3

        assertEquals(expected, result)
    }


    @Test
    fun delete_ExistNote() {
        val note1 = Notes("1","",1, 1, "", "",1, 1, "", 1)
        val note2 = Notes("2","",1, 1, "", "",2, 1, "", 1)
        val note3 = Notes("3","",1, 1, "", "",3, 1, "", 1)

        serviceTest.add(note1)
        serviceTest.add(note2)
        serviceTest.add(note3)

        val result = serviceTest.delete(1)

        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun delete_NotExistNote() {
        val note1 = Notes("1","",1, 1, "", "",1, 1, "", 1)
        val note2 = Notes("2","",1, 1, "", "",2, 1, "", 1)
        val note3 = Notes("3","",1, 1, "", "",6, 1, "", 1)

        serviceTest.add(note1)
        serviceTest.add(note2)
        serviceTest.add(note3)

        serviceTest.delete(100)
    }

    @Test(expected = NoteNotFoundException::class)
    fun delete_FromEmptyList() {
        serviceTest.delete(1)
    }

    @Test
    fun edit_ExistNote() {
        val note1 = Notes("1","",1, 1, "", "",1, 1, "", 1)
        val note2 = Notes("2","",1, 1, "", "",2, 1, "", 1)
        val note3 = Notes("3","",1, 1, "", "",6, 1, "", 1)

        serviceTest.add(note1)
        serviceTest.add(note2)
        serviceTest.add(note3)

        val result = serviceTest.edit(note1)

        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun edit_NotExistNote() {
        val note1 = Notes("1","",1, 1, "", "",1, 1, "", 1)
        val note2 = Notes("2","",1, 1, "", "",2, 1, "", 1)
        val note3 = Notes("3","",1, 1, "", "",6, 1, "", 1)

        serviceTest.add(note1)
        serviceTest.add(note2)

        serviceTest.edit(note3)
    }


    @Test(expected = ListIsEmptyException::class)
    fun get_EmptyList() {
        serviceTest.get()
    }

    @Test
    fun getById_ExistNote() {
        val note1 = Notes("1","",1, 1, "", "",1, 1, "", 1)
        val note2 = Notes("2","",1, 1, "", "",2, 1, "", 1)
        val note3 = Notes("3","",1, 1, "", "",6, 1, "", 1)

        serviceTest.add(note1)
        serviceTest.add(note2)

        val result = serviceTest.getById(1)
        val expected = note1

        assertEquals(expected,result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getById_NotExistNote() {
        val note1 = Notes("1","",1, 1, "", "",1, 1, "", 1)
        val note2 = Notes("2","",1, 1, "", "",2, 1, "", 1)
        val note3 = Notes("3","",1, 1, "", "",6, 1, "", 1)

        serviceTest.add(note1)
        serviceTest.add(note2)

        serviceTest.getById(5)


    }


}