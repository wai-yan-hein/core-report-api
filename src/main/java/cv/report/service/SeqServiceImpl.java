package cv.report.service;

import cv.report.entity.SeqKey;
import cv.report.entity.SeqTable;
import cv.report.repo.SeqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeqServiceImpl implements SeqService {
    @Autowired
    private SeqRepo repo;

    @Override
    public int getSeqNo(String type, String period) {
        SeqKey key = new SeqKey(type, period);
        SeqTable seq;
        Optional<SeqTable> op = repo.findById(key);
        if (op.isEmpty()) {
            seq = new SeqTable();
            seq.setKey(key);
            seq.setSeqNo(1);
        } else {
            seq = op.get();
            seq.setSeqNo(seq.getSeqNo() + 1);
        }
        save(seq);
        return seq.getSeqNo();
    }

    @Override
    public SeqTable save(SeqTable seq) {
        return repo.save(seq);
    }
}
