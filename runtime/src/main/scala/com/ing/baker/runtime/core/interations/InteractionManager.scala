package com.ing.baker.runtime.core.interations

import com.ing.baker.il.petrinet.InteractionTransition

class InteractionManager(private var interactionImplementations: Seq[InteractionImplementation] = Seq.empty) {

  def addInteractionImplementation(interactionImplementation: InteractionImplementation) =
    interactionImplementations = interactionImplementations :+ interactionImplementation

  def removedInteractionImplementation(interactionImplementation: InteractionImplementation) =
    interactionImplementations = interactionImplementations.filter(_.name != interactionImplementation.name)

  def getInteractionImplementation(interactionTransition: InteractionTransition[_]) : Option[InteractionImplementation] =
    interactionImplementations.find(_.name == interactionTransition.originalInteractionName)

  def hasInteractionImplementation(interactionTransition: InteractionTransition[_]): Boolean = {
    getInteractionImplementation(interactionTransition).isDefined
  }
}
