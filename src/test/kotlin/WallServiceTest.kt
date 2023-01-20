import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import ru.netology.Post
import ru.netology.WallService
import ru.netology.likes

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPost() {
        val post1 = Post(1, 1, 3, 333, "eee", true, "post", likes(1, true, true, true))
        val post2 = Post(1, 2, 5, 555, "yyy", true, "post", likes(1, true, true, true))
        WallService.add(post1)
        assertEquals(2, WallService.add(post2).id)
    }

    @Test
    fun updateExisting() {
        val post1 = Post(1, 1, 3, 333, "eee", true, "post", likes(1, true, true, true))
        val post2 = Post(1, 2, 5, 555, "yyy", true, "post", likes(1, true, true, true))
    WallService.add(post1)
        assertEquals(true, WallService.update(post2))
    }

    @Test
    fun updateNotExisting() {
        val post1 = Post(1, 1, 3, 333, "eee", true, "post", likes(1, true, true, true))
        val post2 = Post(2, 2, 5, 555, "yyy", true, "post", likes(1, true, true, true))
        WallService.add(post1)
        assertEquals(false, WallService.update(post2))
    }
}