class NoteNotFoundException:Exception("Заметка не найдена")
class CommentNotFoundException: Exception("Комментарий не найден")
class ListIsEmptyException: Exception("Список заметок пуст")