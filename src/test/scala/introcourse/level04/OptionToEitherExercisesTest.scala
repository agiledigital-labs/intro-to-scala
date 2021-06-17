package introcourse.level04

import introcourse.level04.OptionToEitherExercises._
import introcourse.level04.OptionExercises2.{Human, Job}
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funspec.AnyFunSpec

class OptionToEitherExercisesTest extends AnyFunSpec with TypeCheckedTripleEquals {

  describe("findHumanByIdOrError") {

    it("should return a Left with error if humanId is not in humansDatabase") {
      assert(findHumanByIdOrError(1024) === Left(HumanNotFound(1024)))
    }

    it("should return Human with humanId") {
      assert(findHumanByIdOrError(1) === Right(Human("Sally", None)))
      assert(findHumanByIdOrError(2) === Right(Human("Jenny", Some(1))))
    }

  }

  describe("findJobByIdOrError") {

    it("should return a Left with error if jobId is not in jobsDatabase") {
      assert(findJobByIdOrError(1024) === Left(JobNotFound(1024)))
    }

    it("should return Job with jobId") {
      assert(findJobByIdOrError(1) === Right(Job("Teacher", "Expert in their field")))
      assert(findJobByIdOrError(2) === Right(Job("Engineer", "Build things for people")))
    }

  }

  describe("findJobByHumanIdOrError") {

    it("should return a Left with HumanNotFound if humanId is not in humansDatabase") {
      assert(findJobByHumanIdOrError(1024) === Left(HumanNotFound(1024)))
    }

    it("should return a Left with HumanHasNoJob if humanId is found but Human has no job") {
      assert(findJobByHumanIdOrError(1) === Left(HumanHasNoJob(1))) // Sally
    }

    it("should return a Left with JobNotFound if humanId is found and Human has a job that is not in jobsDatabase") {
      assert(findJobByHumanIdOrError(3) === Left(JobNotFound(1024))) // Timmy
    }

    it("should return jobId if humanId is found and Human has a job that is in jobsDatabase") {
      assert(findJobByHumanIdOrError(2) === Right(Job("Teacher", "Expert in their field"))) // Jenny
    }

  }
}
