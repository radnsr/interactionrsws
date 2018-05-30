package net.unityhealth.repository;

import net.unityhealth.model.TblInteractionsLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface InteractionsActivityLogger
  extends JpaRepository<TblInteractionsLogger, Long>
{}
