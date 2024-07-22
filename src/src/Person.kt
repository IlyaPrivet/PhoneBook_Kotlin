data class Person(
    private var _name: String,
    private var _phone: MutableList<String> = mutableListOf(),
    private var _email: MutableList<String> = mutableListOf()
) {
    fun setName(name: String){ _name = name }

    fun getName(): String{ return _name }

    fun setPhone(phone: String) {
        if (_phone.contains(phone)) {
            println("Номер уже добавлен для контакта")
        } else _phone.add(phone)
    }

    fun getPhone(): MutableList<String> {
        return _phone
    }

    fun setEmail(email: String) {
        if (_email.contains(email)) {
            println("Email уже добавлен для контакта")
        } else _email.add(email)
    }

    fun getEmail(): MutableList<String> {
        return _email
    }

    }
