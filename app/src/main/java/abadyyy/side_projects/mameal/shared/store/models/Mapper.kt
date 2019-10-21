package abadyyy.side_projects.mameal.shared.store.models

interface Mapper<I, O> {
    fun map(input: I): O

    fun revert(output: O): I
}