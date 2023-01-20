package ru.netology

data class likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Post(
    val id: Int,
    val ownerID: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean,
    val postType: String,
    val likes: likes
)

object WallService {
    private var posts = emptyArray<Post>()
    private var newID = 1

    fun add(post: Post): Post {
        posts += post.copy(id = newID++)
        return posts.last()
    }

    fun printAll() {
        for (post in posts) {
            println(post)
        }
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        newID = 1
    }
}

fun main() {
    WallService.add(Post(1, 3, 5, 3434, "hello", false, "post", likes(2, true, true, true)))
    WallService.add(Post(2, 23, 23, 234234, "hello", false, "post", likes(4, true, true, true)))
    val new = Post(1, 33, 55, 3434, "hello", false, "post", likes(2, true, true, true))
    WallService.update(new)
    WallService.printAll()
}