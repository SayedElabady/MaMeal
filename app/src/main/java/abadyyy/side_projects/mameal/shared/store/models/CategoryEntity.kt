package abadyyy.side_projects.mameal.data.store.models

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
data class CategoryEntity(
    @Id
    var id: Long = 0,
    var serverId: String = "",
    var name: String = "",
    var img: String = "",
    var description: String = ""
)