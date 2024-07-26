fun main() {
    println("Здравствуйте")
    var phoneBook = PhoneBook()
    mainMenu(phoneBook)
}

fun mainMenu(phoneBook: PhoneBook) {
    var run = true
    while (run) {
        var (option, input) = readCommand()
        if(option!=null) {
            when (option) {
                is CommandsForConsole.Exit -> run=option.exit()
                is CommandsForConsole.Help -> option.help()
                is CommandsForConsole.AddPhone -> option.addPhone(input, phoneBook)
                is CommandsForConsole.AddEmail -> option.addEmail(input, phoneBook)
                is CommandsForConsole.Show -> option.show(input, phoneBook)
                is CommandsForConsole.Find -> option.find(input, phoneBook)
                is CommandsForConsole.Export -> option.export(input, phoneBook)
            }
        }
        else CommandsForConsole.Help().help()
    }
}

fun readCommand(): Pair<Command?, List<String>> {
    val textMainMenu = "Введите команду:"

    var commands = ListOfCommandsC()
    println(textMainMenu)
    val input = readln().trim().split(" ")
    return Pair(commands.getListOfCommands(input), input)
}

