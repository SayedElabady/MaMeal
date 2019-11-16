package abadyyy.side_projects.mameal.data.store.models

interface Mapper<I, O> {
    fun map(input: I): O

    fun revert(output: O): I
}