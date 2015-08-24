package owen.com.devutils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gc.materialdesign.widgets.SnackBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import owen.com.devutils.R;
import owen.com.devutils.utils.DensityUtil;

/**
 * DP与SP转换
 *
 * Created by Owen on 2015/8/24.
 */
public class DpSpConvertActivity extends Activity {

    @Bind(R.id.edt_input_dp_value)
    EditText mEdtInputDpVal;

    @Bind(R.id.result_dp_2_px)
    TextView mTvDp2PxResult;

    @Bind(R.id.edt_input_px_value)
    EditText mEdtInputPxVal;

    @Bind(R.id.result_px_2_dp)
    TextView mTvPx2DpResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dp_sp_convert);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_dp_convert_to_px)
    public void convertDp2Px() {
        if (TextUtils.isEmpty(mEdtInputDpVal.getText().toString())) {
            SnackBar snackbar = new SnackBar(this, getString(R.string.pls_input_dp_value),
                    getString(R.string.ok), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Nothing to do
                        }
                    });
            snackbar.show();

            return;
        }

        int dp2pxResult = DensityUtil.dp2px(this, Float.parseFloat(mEdtInputDpVal.getText().toString()));
        mTvDp2PxResult.setText("" + dp2pxResult);
    }

    @OnClick(R.id.btn_px_convert_to_dp)
    public void convertPx2Dp() {
        if (TextUtils.isEmpty(mEdtInputPxVal.getText().toString())) {
            SnackBar snackbar = new SnackBar(this, getString(R.string.pls_input_px_value),
                    getString(R.string.ok), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Nothing to do
                }
            });
            snackbar.show();

            return;
        }

        int dp2pxResult = DensityUtil.px2dp(this, Float.parseFloat(mEdtInputPxVal.getText().toString()));
        mTvPx2DpResult.setText("" + dp2pxResult);
    }

}
