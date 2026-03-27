package com.hms.service;

import com.hms.entity.Undergoes;
import com.hms.entity.UndergoesId;

import java.util.List;

public interface UndergoesService {

    Undergoes saveUndergoes(Undergoes undergoes);

    List<Undergoes> getAllUndergoes();

    Undergoes getUndergoesById(UndergoesId id);

    void deleteUndergoes(UndergoesId id);
}