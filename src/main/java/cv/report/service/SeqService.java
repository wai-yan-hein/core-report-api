package cv.report.service;

import cv.report.entity.SeqTable;

public interface SeqService {
    int getSeqNo(String type, String period);

    SeqTable save(SeqTable seq);
}
