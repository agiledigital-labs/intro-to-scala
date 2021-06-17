package introcourse.level04

import introcourse.level04.OptionExercises2.{ Human, Job, HumanId, JobId, humansDatabase, jobsDatabase }

/**
  * These exercises mirror the ones from `OptionExercises2.scala`,
  * instead, we'll use Eithers to model our failure cases.
  */
object OptionToEitherExercises {

  sealed trait ExerciseError
  case class HumanNotFound(humanId: HumanId) extends ExerciseError
  case class JobNotFound(jobId: JobId) extends ExerciseError
  case class HumanHasNoJob(humanId: HumanId) extends ExerciseError

  type ErrorOr[A] = Either[ExerciseError, A]

  /**
    * scala> findHumanByIdOrError(1)
    * > Right(Human("Sally", None))
    *
    * scala> findHumanByIdOrError(100)
    * > Left(HumanNotFound(100))
    *
    * Hint: Look at `toRight` method on Option
    **/
  def findHumanByIdOrError(humanId: HumanId): ErrorOr[Human] = ???

  /**
    * scala> findJobByIdOrError(1)
    * > Right(Job("Teacher", "Expert in their field"))
    *
    * scala> findJobByIdOrError(100)
    * > Left(JobNotFound(100))
    *
    * Hint: Look at `toRight` method on Option
    **/
  def findJobByIdOrError(jobId: JobId): ErrorOr[Job] = ???

  /**
    * Rewrite this function using for-comprehension syntax.
    *
    * scala> findJobByHumanIdOrError(1)
    * > Left(HumanHasNoJob(1))
    *
    * scala> findJobByHumanIdOrError(3)
    * > Left(JobNotFound(1024))
    *
    * scala> findJobByHumanIdOrError(100)
    * > Left(HumanNotFound(100))
    *
    * scala> findJobByHumanIdOrError(2)
    * > Right(Job("Teacher", "Expert in their field"))
    *
    * Hint: Use a for comprehension
    */
  def findJobByHumanIdOrError(humanId: HumanId): ErrorOr[Job] = ???

}
