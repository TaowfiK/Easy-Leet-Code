package solutions._13

class RomanToInteger {

    private var romanNumbers: MutableMap<Char, Int> = mutableMapOf()
    private var condition: Boolean = true
    private var romanInput: String = ""
    private var result: Int = 0

    fun romanToInt(s: String): Int {
        romanInput += s
        addRomanNumbers()
        condition = checkCondition()
        return calculateResult()
    }

    private fun calculateResult(): Int {
        when (condition) {
            true -> {
                for (c in romanInput) {
                    result += romanNumbers[c]!!
                }
            }
            false -> {
                var i = 0
                while (i <= romanInput.length - 1) {
                    when {
                        i == romanInput.length - 1 -> {
                            result += romanNumbers[romanInput[i]]!!
                            i++
                        }
                        romanNumbers[romanInput[i + 1]]!! > romanNumbers[romanInput[i]]!! -> {
                            result += romanNumbers[romanInput[i + 1]]!! - romanNumbers[romanInput[i]]!!
                            i += 2
                        }
                        else -> {
                            result += romanNumbers[romanInput[i]]!!
                            i++
                        }
                    }
                }
            }
        }
        return result
    }

    private fun checkCondition(): Boolean {
        var firstValue = 1001
        for (c in romanInput) {
            var correspondingSymbol: Int = romanNumbers[c]!!
            if (firstValue >= correspondingSymbol!!)
                firstValue = correspondingSymbol
            else
                // means sub condition
                return false
        }
        // means add condition
        return true
    }

    private fun addRomanNumbers() {
        romanNumbers['I'] = 1
        romanNumbers['V'] = 5
        romanNumbers['X'] = 10
        romanNumbers['L'] = 50
        romanNumbers['C'] = 100
        romanNumbers['D'] = 500
        romanNumbers['M'] = 1000
    }

}