class ListOfCommandsC {
    private var commands: MutableList<Command> = mutableListOf(
    CommandsForConsole.Exit(),
    CommandsForConsole.Help(),
    CommandsForConsole.AddPhone(),
    CommandsForConsole.AddEmail(),
    CommandsForConsole.Show()
    )

    fun getListOfCommands(input: List<String>): Command?{
        return commands.find { it.isValid(input) }
    }
}