class PhoneBook {
    private var _phoneBook: MutableList<Person> = mutableListOf()

    fun addContact(person: Person){
        if (!_phoneBook.contains(person)) {
            _phoneBook.add(person)
            println("контакт ${person.getName()} добавлен")
        }
        else println("Контакт уже существует")
    }

    fun getContact(name: String): Person?{
        _phoneBook.forEach { el ->
            if (el.getName() == name) return el
        }
        return null
    }

    fun getLastContact(): Person?{
        return _phoneBook.lastOrNull()
    }
}