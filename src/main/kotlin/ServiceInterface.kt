interface ServiceInterface<E> {
    fun add(element: E): Int
    fun delete(id: Int): Boolean
    fun edit(element: E): Boolean
    fun get(): List<E>

}