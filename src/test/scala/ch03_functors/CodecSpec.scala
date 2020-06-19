package ch03_functors

import org.scalatest.{WordSpec, Matchers}

class CodecSpec extends WordSpec with Matchers {
  "Codec" should {
    "encode boolean value into string" in {
      import ch03_functors.Codec.booleanCodec

      Codec.encode(true) shouldBe "yes"
      Codec.encode(false) shouldBe "no"
    }

    "decode string value into boolean" in {
      import ch03_functors.Codec.booleanCodec

      Codec.decode("yes") shouldBe true
      Codec.decode("no") shouldBe false
    }

    "encode and decode Box into string value and vice versa" in {
      import ch03_functors.Codec.boxCodec

      Codec.encode(Box(123.4)) shouldBe "123.4"
      Codec.decode[Box[Double]]("123.4") shouldBe Box(123.4)
    }
  }
}
