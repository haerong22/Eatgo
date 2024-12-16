package org.example.kotlintestframework.kotest.style

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FunSpecExample : FunSpec({

    test("String length 는 문자열의 길이를 반환해야 한다.") {
        "test".length shouldBe 4
        "".length shouldBe 0
    }

    context("toInt") {

        test("숫자 형태 문자를 숫자로 변환한다.") {
            "12345".toInt() shouldBe 12345
        }

        test("숫자형태가 아니면 exception") {
            shouldThrow<NumberFormatException> {
                "string".toInt()
            }
        }
    }
})