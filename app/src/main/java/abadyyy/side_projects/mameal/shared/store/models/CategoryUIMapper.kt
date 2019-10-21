package abadyyy.side_projects.mameal.shared.store.models


class CategoryUIMapper :
    Mapper<CategoriesResponse.Category, CategoryEntity> {
    override fun map(input: CategoriesResponse.Category): CategoryEntity {
        return CategoryEntity(
            0,
            input.categoryId,
            input.name,
            input.imgUrl,
            input.description
        )
    }

    override fun revert(output: CategoryEntity): CategoriesResponse.Category {
        return CategoriesResponse.Category(
            output.serverId,
            output.name,
            output.img,
            output.description
        )
    }

}